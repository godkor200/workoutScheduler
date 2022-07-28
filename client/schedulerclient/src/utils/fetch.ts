import React, { useEffect } from 'react';
import { Alert } from 'react-native';
import { axiosInstance } from '../App';
import AsyncStorage from '@react-native-async-storage/async-storage';

const useFetch = (url: string) => {
  useEffect(() => {
    get();
  }, []);
  const get = async () => {
    axiosInstance.interceptors.request.use((config) => {
      console.log('===!', config);
    });

    AsyncStorage.getItem('accessToken', async (err, result) => {
      await axiosInstance
        .get(url, { headers: { Authorization: 'Bearer ' + result } })
        .then((res) => console.log('======>', res))
        .catch((err) => console.log(err));
    });
  };
};

export default useFetch;
