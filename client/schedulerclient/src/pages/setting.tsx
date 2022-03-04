import React from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import { ProfileScreenNavigationProp } from 'types/global.interface';
import { useAuth } from '../App';

type Props = {
  navigation: ProfileScreenNavigationProp;
};

export default function Setting({ navigation }: Props) {
  const { signOut } = useAuth();
  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>Setting</Text>
      <TouchableOpacity
        onPress={async () => {
          //          await signOut();
          navigation.navigate('Greeting');
        }}
      >
        <Text>로그아웃</Text>
      </TouchableOpacity>
    </View>
  );
}
