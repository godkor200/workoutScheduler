import React from 'react';
import { RootStackParamList } from 'types/global.interface';
import { StackNavigationProp } from '@react-navigation/stack';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  TouchableOpacity,
} from 'react-native';

type ProfileScreenNavigationProp = StackNavigationProp<
  RootStackParamList,
  'Greeting'
>;

type Props = {
  navigation: ProfileScreenNavigationProp;
};

export default function Greeting({ navigation }: Props) {
  return (
    <>
      <SafeAreaView style={styles.sectionContainer}>
        <View style={styles.sectionTitleSec}>
          <Text style={styles.sectionTitleText}>반가워요👋</Text>
        </View>
        <View style={styles.sectionDescriptionSec}>
          <Text style={styles.sectionDescriptionSecText}>삼대오백도</Text>
          <Text style={styles.sectionDescriptionSecText}>한걸음부터</Text>
        </View>
        <View style={styles.buttonContainer}>
          <TouchableOpacity style={styles.buttonSec}>
            <Text style={styles.buttonText}>득근일지 사용방법 보기</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.buttonSec}
            onPress={() => navigation.navigate('Registration')}
          >
            <Text style={styles.buttonText}>시작하기</Text>
          </TouchableOpacity>
        </View>
      </SafeAreaView>
    </>
  );
}
const styles = StyleSheet.create({
  sectionContainer: {
    flex: 1,
  },
  sectionTitleSec: {
    flex: 1,
    marginTop: 243,
  },
  sectionTitleText: {
    fontSize: 26,
    textAlign: 'center',
    fontWeight: 'bold',
  },
  sectionDescriptionSec: {
    flex: 2,
  },
  sectionDescriptionSecText: {
    textAlign: 'center',
    fontSize: 14,
    color: '#608080',
    lineHeight: 22,
  },
  buttonContainer: {
    flex: 3,
  },
  buttonSec: {
    padding: 20,
    marginHorizontal: 20,
    marginBottom: 8,
    borderRadius: 16,
    backgroundColor: '#CACACA',
  },
  buttonText: {
    textAlign: 'center',
    fontSize: 16,
    color: '#606060',
    fontWeight: 'bold',
  },
});
