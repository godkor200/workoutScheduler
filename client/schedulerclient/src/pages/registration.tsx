import React, { useState } from 'react';
import { RootStackParamList } from 'types/global.interface';
import { StackNavigationProp } from '@react-navigation/stack';
import { useAuth } from '../App';
import {
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  Animated,
  Easing,
  TextInput,
  Alert,
} from 'react-native';

type ProfileScreenNavigationProp = StackNavigationProp<
  RootStackParamList,
  'Registration'
>;
type Props = {
  navigation: ProfileScreenNavigationProp;
};

export default function registration({ navigation }: Props) {
  const { signUp, isSignout } = useAuth();

  const [userData, setUserData] = useState({
    username: '',
    password: '',
    confirmPassword: '',
    male: 'male',
    height: '',
    weight: '',
  });
  const [genderPress, setGenderPress] = useState(false);
  const matchPw = (pw: string, confirmPw: string) =>
    pw !== confirmPw ? Alert.alert('비밀번호가 맞지 않습니다.') : false;

  const genderPressHandler = () => setGenderPress(!genderPress);
  return (
    <SafeAreaView>
      <View style={styles.sectionContainer}>
        <View style={styles.sectionTitleSec}>
          <Text>{`닉네임`}</Text>
          <TextInput
            style={styles.sectionInput}
            placeholder={'닉네임(5자 이상, 영문, 숫자)'}
            onChangeText={(userName) =>
              setUserData({ ...userData, username: userName })
            }
          />
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`비밀번호`}</Text>
          <TextInput
            style={styles.sectionInput}
            secureTextEntry={true}
            placeholder={'비밀번호(5자 이상, 영문, 숫자, 특수문자)'}
            onChangeText={(pw) => setUserData({ ...userData, password: pw })}
          />
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`비밀번호 확인`}</Text>
          <TextInput
            style={styles.sectionInput}
            secureTextEntry={true}
            placeholder={'비밀번호 확인(5자 이상, 영문, 숫자, 특수문자)'}
            onChangeText={(confirmPw) =>
              setUserData({ ...userData, confirmPassword: confirmPw })
            }
          />
        </View>
        <View style={styles.sectionTitleSec}>
          <Text
            style={styles.sectionDescriptionSecText}
          >{`정보를 입력하면 통계 데이터를 볼 수 있어요`}</Text>
          <Text style={styles.sexText}>{`성별`}</Text>
          <View style={styles.containerManOrWomen}>
            <TouchableOpacity
              style={{
                ...styles.buttonSecLeft,
                backgroundColor: genderPress ? '#CACACA' : '#3466E8',
              }}
              onPress={() => {
                genderPressHandler();
                setUserData({ ...userData, male: 'male' });
              }}
            >
              <Text>남자</Text>
            </TouchableOpacity>
            <TouchableOpacity
              style={{
                ...styles.buttonSecRight,
                backgroundColor: !genderPress ? '#CACACA' : '#3466E8',
              }}
              onPress={() => {
                genderPressHandler();
                setUserData({ ...userData, male: 'famale' });
              }}
            >
              <Text>여자</Text>
            </TouchableOpacity>
          </View>
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`키`}</Text>
          <TextInput
            style={styles.sectionInput}
            placeholder={'cm(숫자)'}
            onChangeText={(tall) => setUserData({ ...userData, height: tall })}
          />
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`몸무게`}</Text>
          <TextInput
            style={styles.sectionInput}
            placeholder={'kg(숫자)'}
            onChangeText={(weight) =>
              setUserData({ ...userData, weight: weight })
            }
          />
        </View>
        <TouchableOpacity
          style={styles.RegisterButton}
          onPress={async () => {
            matchPw(userData.password, userData.confirmPassword);
            signUp(userData);
            !isSignout && navigation.navigate('MainStackScreen');
          }}
        >
          <Text style={{ textAlign: 'center' }}>가입완료</Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
}
const styles = StyleSheet.create({
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
  sectionContainer: {
    marginTop: 108,
    marginHorizontal: 24,
  },
  sectionDescriptionSecText: {
    margin: 12,
    fontSize: 14,
    color: '#808080',
  },
  containerManOrWomen: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  buttonSecLeft: {
    paddingHorizontal: 68,
    paddingVertical: 11,
    borderBottomLeftRadius: 8,
    borderTopLeftRadius: 8,
  },
  buttonSecRight: {
    marginLeft: 1,
    paddingHorizontal: 68,
    paddingVertical: 11,
    borderBottomRightRadius: 8,
    borderTopRightRadius: 8,
  },
  sexText: {
    paddingBottom: 8,
  },
  RegisterButton: {
    alignItems: 'center',
    paddingVertical: 17,
    backgroundColor: '#3466E8',
    marginTop: 90,
    borderRadius: 16,
  },
});
