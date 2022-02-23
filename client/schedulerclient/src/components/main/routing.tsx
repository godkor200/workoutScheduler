import React, { useState } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import CheckBox from '@react-native-community/checkbox';
const list = [
  {
    event: '하이바 스쿼트',
    weight: '30',
    set: '4',
  },
  {
    event: '루마니안 데드리프트',
    weight: '20',
    set: '4',
  },
  {
    event: '힙 쓰러스트',
    weight: '40',
    set: '4',
  },
  {
    event: '레그 익스텐션',
    weight: '25',
    set: '4',
  },
  {
    event: '트레드밀',
    time: '40',
  },
];

export default function routing() {
  const [toggleCheckBox, setToggleCheckBox] = useState(false);

  return (
    <View>
      {list.map((e, i) => {
        return (
          <View key={i} style={styles.routingContent}>
            <Text style={styles.eventNumber}>{i + 1}</Text>
            <View style={styles.routingContentInnerBox}>
              <Text style={styles.eventTitle}>{e.event}</Text>
              {!e.time ? (
                <Text style={styles.eventDescription}>
                  {e.weight}kg·{e.set}set
                </Text>
              ) : (
                <Text style={styles.eventDescription}>{e.time}분</Text>
              )}
              <CheckBox
                style={styles.CheckBox}
                tintColor={'#CDD1E1'}
                onCheckColor={'#ffffff'}
                onFillColor={'#0A59D1'}
                disabled={false}
                value={toggleCheckBox}
                onValueChange={(newValue) => setToggleCheckBox(newValue)}
              />
            </View>
          </View>
        );
      })}
      <TouchableOpacity style={styles.addRoutingButton}>
        <Text style={styles.addRoutingText}>+ 운동 추가하기</Text>
      </TouchableOpacity>
    </View>
  );
}
const styles = StyleSheet.create({
  addRoutingButton: {
    borderRadius: 50,
    borderColor: '#969CAC',
    borderWidth: 1,
    alignItems: 'center',
    justifyContent: 'center',
    paddingVertical: 19,
    paddingHorizontal: 125,
  },
  addRoutingText: {
    color: '#969CAC',
  },
  routingContent: {
    alignItems: 'center',
    flexDirection: 'row',
  },
  routingContentInnerBox: {
    display: 'flex',
    marginVertical: 8,
    backgroundColor: '#F4F6FA',
    borderRadius: 12,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    width: '90%',
  },
  eventTitle: {
    marginVertical: 19,
    marginLeft: 16,
  },
  eventDescription: {
    paddingLeft: 12,
  },
  eventNumber: {
    margin: 10,
  },
  CheckBox: {
    marginRight: 16,
  },
});
