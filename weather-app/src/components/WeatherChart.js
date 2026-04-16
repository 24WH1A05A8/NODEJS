import React from &quot;react&quot;;
import { Line } from &quot;react-chartjs-2&quot;;
import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
} from &quot;chart.js&quot;;
ChartJS.register(LineElement, CategoryScale, LinearScale, PointElement);
const WeatherChart = ({ data }) =&gt; {
  if (!data) return null;
  const labels = data.list.slice(0, 8).map(x =&gt; x.dt_txt);
  const temps = data.list.slice(0, 8).map(x =&gt; x.main.temp);
  const chartData = {
    labels,
    datasets: [
      {

        label: &quot;Temperature (°C)&quot;,
        data: temps,
        borderColor: &quot;blue&quot;,
        backgroundColor: &quot;rgba(0,0,255,0.2)&quot;,
        fill: true,
        tension: 0.3
      },
    ],
  };
  return &lt;Line data={chartData} /&gt;;
};
export default WeatherChart;