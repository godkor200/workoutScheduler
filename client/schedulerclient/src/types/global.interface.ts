import { StackNavigationProp } from '@react-navigation/stack';

export type RootStackParamList = {
  Greeting: undefined; // undefined because you aren't passing any params to the home screen
  MainStackScreen: undefined;
  login: undefined;
  Registration: undefined;
  Analysis: undefined;
};

export type ProfileScreenNavigationProp = StackNavigationProp<
  RootStackParamList,
  'Registration'
>;
