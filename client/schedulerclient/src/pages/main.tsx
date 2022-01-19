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
  const [calender, setCalender] = useState(false);
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
  const onClickCalender = () => setCalender(!calender);
  const animationStyles = { transform: [{ rotate: resultDeg }] };

  return (
    <SafeAreaView>
      <View style={styles.headerContainer}>
        <Text style={styles.headerText}>오늘은 {'\n'} 하체 하는 날</Text>
        <TouchableOpacity style={styles.headerButton}>
          <Text style={styles.headerButtonText}>루틴 변경</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.container}>
        <Text>{weekOfMonth(date)}</Text>
        <Animated.View style={[animationStyles]}>
          <Icon
            name="down"
            size={14}
            color="black"
            onPress={() => {
              up();
              onClickCalender();
            }}
          />
        </Animated.View>
      </View>
      <Calender
        calender={calender}
        date={date}
        onChange={(newDate) => setDate(newDate)}
      />
      <View style={styles.routinCon}>
        <Text style={styles.routinTitle}>오늘의 루틴</Text>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    padding: 20,
  },
  headerContainer: {
    flexDirection: 'row',
    overflow: 'hidden',
    margin: 20,
    justifyContent: 'space-between',
  },
  headerText: {
    fontSize: 26,
  },
  headerButton: {
    backgroundColor: '#ffffff',
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 9.5,
    paddingHorizontal: 12,
  },
  headerButtonText: {
    letterSpacing: -0.01,
  },
  routinCon: {
    margin: 20,
  },
  routinTitle: {
    fontSize: 20,
  },
});
