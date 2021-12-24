import { startOfWeek } from 'date-fns';

const dayConvent = (enDay: string) =>
  enDay == 'Mon'
    ? '월'
    : enDay == 'Tue'
    ? '화'
    : enDay == 'Wed'
    ? '수'
    : enDay == 'Thu'
    ? '목'
    : enDay == 'Fri'
    ? '금'
    : enDay == 'Sat'
    ? '토'
    : '일';

const weekOfMonth = (m: Date) => {
  const baseDate = startOfWeek(m, { weekStartsOn: 0 });
  const baseMonth = baseDate.getMonth() + 1;
  const baseDays = baseDate.getDate() + 1;
  const weekOfMonth = Math.ceil(baseDays / 7);
  return `${baseMonth}월 ${weekOfMonth + 1}주차`;
};

export { dayConvent, weekOfMonth };
