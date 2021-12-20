import React, { useState } from 'react'
import {
    SafeAreaView,
    ScrollView,
    StatusBar,
    StyleSheet,
    Text,
    useColorScheme,
    View,
    TouchableOpacity
} from 'react-native';
import Calender from '@components/main/calender'



export default function Main() {
    const [date, setDate] = useState(new Date());
    console.log(date);
    return (
        <SafeAreaView>
            <Text>
                {`오늘은 하체 하는 날`}
            </Text>
            <TouchableOpacity>
                <Text>
                    루틴 변경
                </Text>
            </TouchableOpacity>
            <Calender date={date} />
        </SafeAreaView>
    )
}
