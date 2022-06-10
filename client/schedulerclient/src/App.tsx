/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, { useReducer, useEffect, useMemo, createContext } from 'react';
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { StackNavigationProp } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import {
  RootStackParamList,
  ProfileScreenNavigationProp,
} from 'types/global.interface';
import {
  AuthContextType,
  AuthState,
  AuthContextActions,
  AuthSignUpPayload,
  AuthSignInPayload,
  AuthType,
  Token,
} from 'types/auth.interface';
import Greeting from '@pages/greeting';
import MainStackScreen from '@components/mainStackScreen';
import Registration from '@pages/registration';
import Login from '@pages/login';
import Analysis from '@pages/analysis';
import { Alert } from 'react-native';

export const AuthContext = createContext<AuthContextType>({
  isLoading: true,
  isSignout: false,
  userToken: null,
  signIn: async (data: AuthSignInPayload) => {
    return undefined;
  },
  signUp: async (data: AuthSignUpPayload) => {
    return undefined;
  },
  signOut: () => {},
});

export const axiosInstance = axios.create({
  baseURL: 'http://3.34.91.5:8080',
  withCredentials: true,
});

const Stack = createNativeStackNavigator<RootStackParamList>();

const reducer = (
  prevState: AuthState,
  action: { type: string; token: string | undefined | null },
): AuthState => {
  switch (action.type) {
    case 'RESTORE_TOKEN':
      return { ...prevState, userToken: action.token, isLoading: false };
    case 'SIGN_IN':
      return { ...prevState, isSignout: false, userToken: action.token };
    case 'SIGN_OUT':
      return { ...prevState, isSignout: true, userToken: null };
    default:
      return { isLoading: true, isSignout: false, userToken: null };
  }
};

type Props = {
  navigation: ProfileScreenNavigationProp;
};

export const useAuth = (): AuthContextType => {
  const context = React.useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be inside an AuthProvider with a value');
  }
  /*
    you can add more drived state here
    const isLoggedIn  = context.status ==== 'signIn'
    return ({ ...context, isloggedIn})
  */
  return context;
};

const App = ({ navigation }: Props) => {
  const apiUrl = 'http:localhost:8080';
  const [state, dispatch] = useReducer(reducer, {
    isLoading: true,
    isSignout: false,
    userToken: null,
  });

  useEffect(() => {
    //Storage에서 토큰 가져옴, 다른 화면으로 네이게이트
    const bootStrapAsync = async () => {
      let userToken;
      try {
        userToken = await AsyncStorage.getItem('userToken');
      } catch (error) {
        //TODO: alret
      }
      //TODO: 토큰 유효한지 안한지?

      dispatch({ type: 'RESTORE_TOKEN', token: userToken });
    };
    bootStrapAsync();
  }, []);

  const authContext: AuthContextActions = useMemo(
    () => ({
      signIn: async (data: AuthSignInPayload) => {
        const { username, password } = data;
        // 여기서 아이디와 비밀번호 서버로 보내고 토큰 받아옴
        let userToken = '';
        const option = { username: username, password: password };
        try {
          const res = await axiosInstance.post(`/api/user/signin`, option);
          userToken = await res.data.token;
        } catch (e) {
          Alert.alert('서버가 응답하지 않습니다. 잠시후에 시도해주세요.');
        }
        // 받아온 토큰 저장
        try {
          await AsyncStorage.setItem('@storage_Key', userToken);
          // axiosInstance.interceptors.request.use(async (config) => {
          //   config.headers = { Authorization: 'Bearer ' + userToken };
          //   return config;
          // });
          return 'OK';
        } catch (e) {
          //TODO: 토큰 저장 오류 처리
          Alert.alert('토큰이 저장되지 않았습니다. 잠시후에 시도해주세요.');
        }
        dispatch({ type: 'SIGN_IN', token: userToken });
      },
      signOut: async () => dispatch({ type: 'SIGN_OUT', token: null }),

      signUp: async (data: AuthSignUpPayload) => {
        let userToken = '';
        const option = {
          username: data.username,
          password: data.password,
          male: data.isMale,
          height: data.height,
          weight: data.weight,
        };
        try {
          const res = await axiosInstance.post(`/api/user/signup`, option);
          userToken = res.data.token;
        } catch (e) {
          Alert.alert('서버가 응답하지 않습니다. 잠시후에 시도해주세요.');
        }
        try {
          await AsyncStorage.setItem('storage_Key', userToken);
          dispatch({ type: 'SIGN_IN', token: userToken });
          return 'OK';
        } catch (e) {
          Alert.alert(
            '사용자 정보를 저장하는데 실패 했습니다. 잠시후에 시도해주세요.',
          );
        }
      },
    }),
    [],
  );
  /**
   * 로그인 여부 로그인이 되어 있으면 greeting할 필요없음!
   */

  return (
    <AuthContext.Provider value={{ ...state, ...authContext }}>
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Greeting">
          {/* {state.isLoading ? } */}
          {!state.isSignout ? (
            // <Stack.Screen
            //   name="Greeting"
            //   component={Greeting}
            //   options={{ headerShown: false }}
            // />
            <Stack.Screen
              name="login"
              component={Login}
              options={{ headerShown: false }}
            />
          ) : (
            <Stack.Screen
              name="MainStackScreen"
              component={MainStackScreen}
              options={{ headerShown: false }}
            />
          )}
          <Stack.Screen
            name="MainStackScreen"
            component={MainStackScreen}
            options={{ headerShown: false }}
          />
          <Stack.Screen
            name="Registration"
            component={Registration}
            options={{ headerShown: false }}
          />
          <Stack.Screen
            name="Analysis"
            component={Analysis}
            options={{ headerShown: true }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </AuthContext.Provider>
  );
};

export default App;
