import React, { useState, useEffect } from 'react';
import { View, Text, SafeAreaView, StyleSheet } from 'react-native';
import WeekCalendar from '@components/main/weekCalender';
import MouthCalender from '@components/main/mouthCalender';

interface Props {
  calender: boolean;
  date: Date;
  onChange: (value: Date) => void;
}

export default function calender({ calender, date, onChange }: Props) {
  return (
    <SafeAreaView>
      {calender ? (
        <MouthCalender />
      ) : (
        <WeekCalendar date={date} onChange={onChange} />
      )}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  // safe: {
  //   flex: 2,
  // },
});
