/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, { useState } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { RootStackParamList } from 'types/global.interface'
import Greeting from '@pages/greeting'
import Main from '@pages/main'
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  TouchableOpacity
} from 'react-native';

const Stack = createNativeStackNavigator<RootStackParamList>();

const App = () => {
  /**
   * 로그인 여부 로그인이 되어 있으면 greeting할 필요없음
   */
  const [login, setLogin] = useState(false);
  return (
    <>
      <NavigationContainer>
        <Stack.Navigator initialRouteName='Greeting'>
          <Stack.Screen name="Greeting" component={Greeting} />
          <Stack.Screen name="Main" component={Main} />
        </Stack.Navigator>
      </NavigationContainer>

    </>
  );
};



export default App;
