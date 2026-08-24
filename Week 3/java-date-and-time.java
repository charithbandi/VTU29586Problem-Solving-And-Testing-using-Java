

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        
        // Calendar months are 0-indexed (January is 0, August is 7)
        cal.set(year, month - 1, day);
        
        int dayOfWeekIndex = cal.get(Calendar.DAY_OF_WEEK);
        
        String[] days = new DateFormatSymbols(Locale.US).getWeekdays();
        
        return days[dayOfWeekIndex].toUpperCase();

    }

}

