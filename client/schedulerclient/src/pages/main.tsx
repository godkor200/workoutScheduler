import React, { useState, useEffect, useRef } from 'react';
import moment from 'moment';
import { weekOfMonth } from '@utils/common';
import Calender from '@components/main/calender';
import Icon from 'react-native-vector-icons/AntDesign';
import {
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  Animated,
  Easing,
} from 'react-native';

export default function Main() {
  const [date, setDate] = useState(moment().utc(true).toDate());

  const deg = useRef(new Animated.Value(0)).current;

  const resultDeg = deg.interpolate({
    inputRange: [0, 1],
    outputRange: ['0deg', '180deg'],
  });

  const up = () => {
    Animated.timing(deg, {
      toValue: 1,
      duration: 500,
      useNativeDriver: true,
    }).start();
  };

  const animationStyles = { transform: [{ rotate: resultDeg }] };

  return (
    <SafeAreaView>
      <Text>{`오늘은 하체 하는 날`}</Text>
      <TouchableOpacity>
        <Text>루틴 변경</Text>
      </TouchableOpacity>
      <View style={styles.container}>
        <Text>{weekOfMonth(date)}</Text>
        <Animated.View style={[animationStyles]}>
          <Icon
            name="down"
            size={14}
            color="black"
            onPress={() => {
              console.log(deg);
              up();
            }}
          />
        </Animated.View>
      </View>
      <Calender date={date} onChange={(newDate) => setDate(newDate)} />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
  },
});
