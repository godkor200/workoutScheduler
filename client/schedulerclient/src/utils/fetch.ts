import React, { useEffect } from 'react';
import { Alert } from 'react-native';
import { axiosInstance } from '../App';

const useFetch = (url: string) => {
  useEffect(() => {
    get();
  }, []);
  const get = async () => {
    const result = await axiosInstance
      .get(url)
      .then((res) => console.log('======>', res))
      .catch((err) => console.log(err));
  };
};

export default useFetch;
