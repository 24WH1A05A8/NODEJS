import axios from &quot;axios&quot;;
const API_KEY = &quot;YOUR API KEY&quot;;
export const getWeather = async (city) =&gt; {
  const res = await axios.get(
    `https://api.openweathermap.org/data/2.5/forecast?q=${city}&amp;appid=${API_KEY}&amp;units=metric`
  );
  return res.data;
};