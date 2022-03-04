import React from 'react';
import Summary from '@components/analysis/summary';
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

export default function analysis() {
  return (
    <SafeAreaView style={{ backgroundColor: '#ffffff' }}>
      <ScrollView>
        <View style={styles.container}>
          <Summary />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    marginHorizontal: 20,
    marginVertical: 64,
  },
});
