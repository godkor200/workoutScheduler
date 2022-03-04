import React, { useState } from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  TouchableOpacity,
  TextInput,
  Alert,
} from 'react-native';
import { ProfileScreenNavigationProp } from 'types/global.interface';
import { useAuth } from '../App';

type Props = {
  navigation: ProfileScreenNavigationProp;
};

export default function Login({ navigation }: Props) {
  const { signIn, userToken } = useAuth();
  const [userData, setUserData] = useState({
    username: '',
    password: '',
  });

  const loginHandler = async () => {
    const { username, password } = userData;
    if (username.length === 0 || password.length === 0) {
      Alert.alert('아이디와 비밀번호를 확인해주세요');
      return;
    }
    const result = await signIn(userData);
    if (result === 'OK') navigation.navigate('MainStackScreen');
    else return;
  };
  return (
    <>
      <View style={styles.sectionContainer}>
        <View style={styles.topBox}>
          <Text style={styles.sectionTitleText}>상상만해도</Text>
          <Text style={styles.sectionTitleText}>득근득근</Text>
        </View>
        <View style={styles.secondBox}>
          <Text style={styles.secondBoxText}>득근일지</Text>
        </View>
        <View>
          <View style={styles.sectionTitleSec}>
            <Text>아이디</Text>
            <TextInput
              style={styles.sectionInput}
              placeholder={'닉네임'}
              onChangeText={(username) => {
                setUserData({ ...userData, username: username });
              }}
            />
          </View>
          <View style={styles.sectionTitleSec}>
            <Text>비밀 번호</Text>
            <TextInput
              style={styles.sectionInput}
              placeholder={'패스워드'}
              onChangeText={(ps) => {
                setUserData({ ...userData, password: ps });
              }}
            />
          </View>
        </View>
        <View>
          <TouchableOpacity
            style={styles.RegisterButton}
            onPress={() => {
              loginHandler();
            }}
          >
            <Text>로그인</Text>
          </TouchableOpacity>
        </View>
        <View>
          <TouchableOpacity style={styles.LoginButton}>
            <Text
              style={{ textDecorationLine: 'underline' }}
              onPress={() => {
                navigation.navigate('Registration');
              }}
            >
              회원가입
            </Text>
          </TouchableOpacity>
        </View>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    margin: 30,
  },
  topBox: {
    // flex: 0.5,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  secondBox: {
    marginTop: 8,
    marginBottom: 50,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  secondBoxText: { fontSize: 26, fontWeight: 'bold' },
  sectionTitleText: {
    fontSize: 15,
    textAlign: 'center',
  },
  sectionTitleSec: {
    marginTop: 20,
  },
  sectionInput: {
    marginTop: 8,
    height: 32,
    borderColor: '#f2f2f2',
    borderBottomColor: '#404040',
    borderWidth: 1,
  },
  LoginButton: {
    alignItems: 'center',
    paddingVertical: 17,
    backgroundColor: '#f2f2f2',
    marginTop: 20,
    borderRadius: 16,
  },
  RegisterButton: {
    alignItems: 'center',
    paddingVertical: 17,
    backgroundColor: '#3466E8',
    marginTop: 20,
    borderRadius: 16,
  },
});
