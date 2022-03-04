import React from 'react';
import Main from '@pages/main';
import { Text } from 'react-native';
import Analysis from '@pages/analysis';
import Setting from '@pages/setting';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { ParamListBase, RouteProp } from '@react-navigation/native';

const Tab = createBottomTabNavigator();

export default function mainStackScreen() {
  const iconSelecter = (
    route: RouteProp<ParamListBase, string>,
    focused: boolean,
    color: string,
    size: number,
  ): JSX.Element => {
    let iconName: string = 'calender';
    switch (route.name) {
      case '운동루틴':
        iconName = focused ? 'calendar' : 'calendar-outline';
        break;
      case '운동분석':
        iconName = focused ? 'ios-pie-chart' : 'ios-pie-chart-outline';
        break;
      case '설정':
        iconName = focused ? 'settings' : 'settings-outline';
        break;
    }
    color = focused ? '#000000' : '#8E8E8F';
    return <Ionicons name={iconName} size={size} color={color} />;
  };
  return (
    <Tab.Navigator
      initialRouteName="Main"
      screenOptions={({ route }) => ({
        tabBarIcon: ({ focused, color, size }) =>
          iconSelecter(route, focused, color, size),
        tabBarLabel: ({ focused }) => (
          <Text style={{ color: focused ? '#000000' : '#8E8E8F' }}>
            {route.name}
          </Text>
        ),
      })}
    >
      <Tab.Screen
        name="운동루틴"
        component={Main}
        options={{ headerShown: false }}
      />
      <Tab.Screen
        name="운동분석"
        component={Analysis}
        // options={{ headerShown: false }}
      />
      <Tab.Screen
        name="설정"
        component={Setting}
        // options={{ headerShown: false }}
      />
    </Tab.Navigator>
  );
}
