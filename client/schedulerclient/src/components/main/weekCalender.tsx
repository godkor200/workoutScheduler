import React, { useState, useEffect } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { dayConvent } from '@utils/common';
import { addDays, format, getDate, isSameDay, startOfWeek } from 'date-fns';

interface Props {
  date: Date;
  onChange: (value: Date) => void;
}

export default function weekCalender({ date, onChange }: Props) {
  const [week, setWeek] = useState<WeekDay[]>([]);

  useEffect(() => {
    const weekDays = getWeekDays(date);
    setWeek(weekDays);
  }, [date]);

  return (
    <View style={styles.container}>
      {week.map((weekDay) => {
        const textStyles = [styles.label];
        const touchable = [styles.touchable];

        const sameDay = isSameDay(weekDay.date, date);
        if (sameDay) {
          textStyles.push(styles.selectedLabel);
          touchable.push(styles.selectedTouchable);
        }

        return (
          <View style={styles.weekDayItem} key={weekDay.formatted}>
            <Text style={styles.weekDayText}>
              {dayConvent(weekDay.formatted)}
            </Text>
            <TouchableOpacity
              onPress={() => onChange(weekDay.date)}
              style={touchable}
            >
              <Text style={textStyles}>{weekDay.day}</Text>
            </TouchableOpacity>
          </View>
        );
      })}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    paddingVertical: 10,
  },
  weekDayText: {
    color: 'gray',
    marginBottom: 5,
  },
  label: {
    fontSize: 14,
    color: 'black',
    textAlign: 'center',
  },
  selectedLabel: {
    fontSize: 14,
    color: 'white',
    textAlign: 'center',
  },
  touchable: {
    borderRadius: 30,
    padding: 7,
    height: 40,
    width: 40,
  },
  selectedTouchable: {
    backgroundColor: '#0A59D1',
    borderRadius: 30,
    width: 40,
    height: 40,
    padding: 7,
  },
  weekDayItem: {
    alignItems: 'center',
  },
});

type WeekDay = {
  formatted: string;
  date: Date;
  day: number;
};

// get week days
export const getWeekDays = (date: Date): WeekDay[] => {
  const start = startOfWeek(date, { locale: { code: 'ko' }, weekStartsOn: 1 });

  const final = [];

  for (let i = 0; i < 7; i++) {
    const date = addDays(start, i);
    final.push({
      formatted: format(date, 'EEE'),
      date,
      day: getDate(date),
    });
  }

  return final;
};
