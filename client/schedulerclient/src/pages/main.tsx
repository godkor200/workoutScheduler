import React, { useState, useEffect, useRef } from 'react';
import moment from 'moment';
import { weekOfMonth } from '@utils/common';
import Calender from '@components/main/calender';
import Icon from 'react-native-vector-icons/AntDesign';
import Routing from '@components/main/routing';
import {
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  Animated,
  ScrollView,
  Easing,
} from 'react-native';
import { axiosInstance } from 'App';
import useFetch from '@utils/fetch';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Main() {
  const [date, setDate] = useState(moment().utc(true).toDate());
  const [calender, setCalender] = useState(false);
  const deg = useRef(new Animated.Value(0)).current;

  const resultDeg = deg.interpolate({
    inputRange: [0, 1],
    outputRange: ['0deg', '180deg'],
  });

  AsyncStorage.getItem('accessToken', (err, result) => {
    console.log('main', result);
  });
  useFetch(`/api/routine`);
  console.log(date);
  const up = () => {
    Animated.timing(deg, {
      toValue: 1,
      duration: 500,
      useNativeDriver: true,
    }).start();
  };
  const onClickCalender = () => setCalender(!calender);
  const animationStyles = {
    transform: [{ rotate: resultDeg }],
  };

  return (
    <SafeAreaView style={styles.container}>
      <ScrollView>
        <View style={styles.headerContainer}>
          <Text style={styles.headerText}>오늘은 {'\n'} 하체 하는 날 🔥</Text>
          <TouchableOpacity style={styles.headerButton}>
            <Text style={styles.headerButtonText}>루틴 변경</Text>
          </TouchableOpacity>
        </View>
        <View style={styles.calendarContainer}>
          <Text style={styles.weekTitleText}>{weekOfMonth(date)}</Text>
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
          <Routing />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: { backgroundColor: '#ffffff' },
  calendarContainer: {
    flexDirection: 'row',
    padding: 20,
    backgroundColor: '#F4F6FA',
  },
  headerContainer: {
    flexDirection: 'row',
    overflow: 'hidden',
    margin: 20,
    justifyContent: 'space-between',
  },
  weekTitleText: { fontSize: 14, fontWeight: 'bold' },
  headerText: {
    fontSize: 26,
    fontWeight: 'bold',
  },
  headerButton: {
    borderRadius: 12,
    backgroundColor: '#F4F6FA',
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
    fontWeight: 'bold',
    paddingBottom: 16,
  },
});
