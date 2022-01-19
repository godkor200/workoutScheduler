import React from 'react';
import { RootStackParamList } from 'types/global.interface';
import { StackNavigationProp } from '@react-navigation/stack';

import {
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  Animated,
  Easing,
  TextInput,
} from 'react-native';

type ProfileScreenNavigationProp = StackNavigationProp<
  RootStackParamList,
  'Registration'
>;
type Props = {
  navigation: ProfileScreenNavigationProp;
};

export default function registration({ navigation }: Props) {
  return (
    <SafeAreaView>
      <View style={styles.sectionContainer}>
        <View style={styles.sectionTitleSec}>
          <Text>{`닉네임`}</Text>
          <TextInput style={styles.sectionInput} />
          <Text
            style={styles.sectionDescriptionSecText}
          >{`정보를 입력하면 통계 데이터를 볼 수 있어요`}</Text>
        </View>
        <View style={styles.sectionTitleSec}>
          <Text style={styles.sexText}>{`성별`}</Text>
          <View style={styles.containerManOrWomen}>
            <TouchableOpacity style={styles.buttonSecLeft}>
              <Text>남자</Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.buttonSecRight}>
              <Text>여자</Text>
            </TouchableOpacity>
          </View>
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`키`}</Text>
          <TextInput style={styles.sectionInput} />
        </View>
        <View style={styles.sectionTitleSec}>
          <Text>{`몸무게`}</Text>
          <TextInput style={styles.sectionInput} />
        </View>
        <TouchableOpacity
          style={styles.RegisterButton}
          onPress={() => navigation.navigate('Main')}
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
    marginTop: 148,
    marginHorizontal: 24,
  },
  sectionDescriptionSecText: {
    marginTop: 32,
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
    backgroundColor: '#CACACA',
    borderBottomLeftRadius: 8,
    borderTopLeftRadius: 8,
  },
  buttonSecRight: {
    marginLeft: 1,
    paddingHorizontal: 68,
    paddingVertical: 11,
    backgroundColor: '#CACACA',
    borderBottomRightRadius: 8,
    borderTopRightRadius: 8,
  },
  sexText: {
    paddingBottom: 8,
  },
  RegisterButton: {
    paddingHorizontal: 140,
    paddingVertical: 17,
    backgroundColor: '#3466E8',
    marginTop: 200,
    borderRadius: 16,
  },
});
