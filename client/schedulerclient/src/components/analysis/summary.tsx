import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

export default function summary() {
  return (
    <>
      <View style={styles.entireContainer}>
        <Text style={styles.title}>요약</Text>
        <View style={styles.periodContainer}>
          <View style={styles.period}>
            <Text>일주일</Text>
          </View>
          <View style={styles.period}>
            <Text>한달</Text>
          </View>
        </View>
        <View style={styles.mainContentContainer}>
          <View style={styles.content}>
            <View style={styles.Figure}>
              <Text style={styles.bigNumber}>17</Text>
              <Text style={styles.smallText}>/ 31</Text>
            </View>
            <View>
              <Text style={styles.Text}>운동 총 횟수</Text>
            </View>
          </View>

          <View style={styles.content}>
            <View style={styles.Figure}>
              <Text style={styles.bigNumber}>3000</Text>
              <Text style={styles.smallText}>kg</Text>
            </View>
            <View>
              <Text style={styles.Text}>총 볼륨</Text>
            </View>
          </View>
        </View>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  entireContainer: {
    // textAlign: 'center',
  },
  periodContainer: { flexDirection: 'row', marginVertical: 12 },
  period: {
    backgroundColor: '#DEE4FA',
    borderRadius: 24,
    margin: 6,
    paddingVertical: 4,
    paddingHorizontal: 12,
  },
  content: { marginVertical: 23, marginHorizontal: 50 },
  Figure: { flexDirection: 'row' },
  bigNumber: { fontSize: 22 },
  smallText: { fontSize: 15 },
  Text: { fontSize: 14 },
  mainContentContainer: {
    flexDirection: 'row',
    backgroundColor: '#F4F6FA',
    width: '100%',
    borderRadius: 16,
  },
  title: {
    fontSize: 22,
  },
});
