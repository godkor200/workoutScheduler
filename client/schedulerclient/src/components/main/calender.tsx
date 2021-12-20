import React, { useState, useEffect } from 'react'
import { View, Text } from 'react-native';
import { Calendar, CalendarList, Agenda } from 'react-native-calendars';
import { LocaleConfig } from 'react-native-calendars';
import { addDays, format, getDate, startOfWeek } from 'date-fns'

LocaleConfig.locales['fr'] = {
    monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
    monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
    dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    today: 'Aujourd\'hui'
};
interface Props {
    date: Date
}
export default function calender({ date }: Props) {

    const [week, setWeek] = useState<any>([])
    useEffect(() => {
        setWeek(getWeekDays(date))
    }, [date])
    const getWeekDays = (date: Date) => {

        const start = startOfWeek(date, { weekStartsOn: 1 })
        const weekOfLength = 7;
        const weekArray = new Array;

        for (let i = 0; i < weekOfLength; i++) {
            weekArray.push({
                formatted: format(date, "EEE"),
                date: addDays(start, i),
                day: getDate(date)
            })
        }

        return weekArray;
    }
    console.log(week)
    return (
        <View style={{ flex: 1 }}>

        </View>
    )
}
