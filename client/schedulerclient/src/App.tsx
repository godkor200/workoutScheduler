/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, {
  useState,
  useReducer,
  Reducer,
  ReducerState,
  useEffect,
  useMemo,
  createContext,
} from 'react';

import Calender from '@components/main/calender';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { RootStackParamList } from 'types/global.interface';
import Greeting from '@pages/greeting';
import MainStackScreen from '@components/mainStackScreen';
import Registration from '@pages/registration';

type AuthType = 'RESTORE_TOKEN' | 'SIGN_IN' | 'SIGN_OUT';
type Token = string | undefined | null;

export const AuthContext = createContext({});

const Stack = createNativeStackNavigator<RootStackParamList>();
function reducer(
  prevState: any,
  action: { type: string; token: string | undefined | null },
) {
  switch (action.type) {
    case 'RESTORE_TOKEN':
      return { ...prevState, userToken: action.token, isLoading: false };
    case 'SIGN_IN':
      return { ...prevState, isSignout: false, userToken: action.token };
    case 'SIGN_OUT':
      return { ...prevState, isSignout: true, userToken: null };
  }
}

const App = () => {
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

  const authContext = useMemo(
    () => ({
      signIn: async (data: any) => {
        // 여기서 아이디와 비밀번호 서버로 보내고 토큰 받아옴
        let userToken = '';

        try {
          //TODO: 서버에서 로그인후 토큰 받아오기
          userToken = await 'dummy-auth-token';
        } catch (e) {
          // 실패 시 에러 처리
        }
        // 받아온 토큰 저장
        try {
          //FIXME: 스토리지 변동 가능성 있음
          await AsyncStorage.setItem('@storage_Key', userToken);
        } catch (e) {
          //TODO: 토큰 저장 오류 처리
        }

        dispatch({ type: 'SIGN_IN', token: userToken });
      },
      signOut: async () => dispatch({ type: 'SIGN_OUT', token: null }),
      signUp: async (data: any) => {
        let userToken = '';
        try {
          //TODO: 서버에 회원가입 데이터 보내고 토큰 받아오기
          userToken = await 'dummy-auth-token';
        } catch (e) {
          //TODO: 실패 시 에러 처리
        }
        try {
          //FIXME: 받아온 토큰 저장
          await AsyncStorage.setItem('@storage_Key', userToken);
        } catch (e) {
          //TODO: 토큰 저장 오류 처리
        }
        dispatch({ type: 'SIGN_IN', token: 'dummy-auth-token' });
      },
    }),
    [],
  );
  /**
   * 로그인 여부 로그인이 되어 있으면 greeting할 필요없음!
   */
  console.log(state.isLoading);
  return (
    <AuthContext.Provider value={authContext}>
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Greeting">
          {/* {state.isLoading ? } */}
          {!state.isSignout ? (
            <Stack.Screen
              name="Greeting"
              component={Greeting}
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
            name="Registration"
            component={Registration}
            options={{ headerShown: false }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </AuthContext.Provider>
  );
};

export default App;
