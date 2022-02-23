import React, { useState, useEffect } from 'react';
import { View, Text, SafeAreaView, StyleSheet } from 'react-native';
import WeekCalendar from '@components/main/weekCalender';

interface Props {
  calender: boolean;
  date: Date;
  onChange: (value: Date) => void;
}

export default function calender({ calender, date, onChange }: Props) {
  return <WeekCalendar calender={calender} date={date} onChange={onChange} />;
}

const styles = StyleSheet.create({});
