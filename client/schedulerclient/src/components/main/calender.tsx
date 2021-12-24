import React, { useState, useEffect } from 'react';
import { View, Text, SafeAreaView, StyleSheet } from 'react-native';
import { Calendar, CalendarList, Agenda } from 'react-native-calendars';
import WeekCalendar from '@components/main/weekCalender';

interface Props {
  date: Date;
  onChange: (value: Date) => void;
}

export default function calender({ date, onChange }: Props) {
  return (
    <SafeAreaView>
      <WeekCalendar date={date} onChange={onChange} />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  // safe: {
  //   flex: 2,
  // },
});
