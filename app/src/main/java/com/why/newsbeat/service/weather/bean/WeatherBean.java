package com.why.newsbeat.service.weather.bean;

/**
 * Created by lenovo on 2017/9/14.
 */

public class WeatherBean {


	/**
	 * resultcode : 200
	 * reason : successed!
	 * result : {"sk":{"temp":"25","wind_direction":"东北风","wind_strength":"1级","humidity":"71%","time":"19:27"},"today":{"temperature":"24℃~29℃","weather":"多云转小雨","weather_id":{"fa":"01","fb":"07"},"wind":"东北风4-5 级","week":"星期四","city":"上海","date_y":"2017年09月14日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"最弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20170914":{"temperature":"24℃~29℃","weather":"多云转小雨","weather_id":{"fa":"01","fb":"07"},"wind":"东北风4-5 级","week":"星期四","date":"20170914"},"day_20170915":{"temperature":"23℃~27℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"5-6 级","week":"星期五","date":"20170915"},"day_20170916":{"temperature":"21℃~27℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风3-4 级","week":"星期六","date":"20170916"},"day_20170917":{"temperature":"21℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期日","date":"20170917"},"day_20170918":{"temperature":"22℃~30℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"南风微风","week":"星期一","date":"20170918"},"day_20170919":{"temperature":"21℃~27℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风3-4 级","week":"星期二","date":"20170919"},"day_20170920":{"temperature":"21℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期三","date":"20170920"}}}
	 * error_code : 0
	 */

	private String resultcode;
	private String reason;
	private ResultBean result;
	private int error_code;

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public static class ResultBean {
		/**
		 * sk : {"temp":"25","wind_direction":"东北风","wind_strength":"1级","humidity":"71%","time":"19:27"}
		 * today : {"temperature":"24℃~29℃","weather":"多云转小雨","weather_id":{"fa":"01","fb":"07"},"wind":"东北风4-5 级","week":"星期四","city":"上海","date_y":"2017年09月14日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"最弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
		 * future : {"day_20170914":{"temperature":"24℃~29℃","weather":"多云转小雨","weather_id":{"fa":"01","fb":"07"},"wind":"东北风4-5 级","week":"星期四","date":"20170914"},"day_20170915":{"temperature":"23℃~27℃","weather":"小雨","weather_id":{"fa":"07","fb":"07"},"wind":"5-6 级","week":"星期五","date":"20170915"},"day_20170916":{"temperature":"21℃~27℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风3-4 级","week":"星期六","date":"20170916"},"day_20170917":{"temperature":"21℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期日","date":"20170917"},"day_20170918":{"temperature":"22℃~30℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"南风微风","week":"星期一","date":"20170918"},"day_20170919":{"temperature":"21℃~27℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风3-4 级","week":"星期二","date":"20170919"},"day_20170920":{"temperature":"21℃~28℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期三","date":"20170920"}}
		 */

		private SkBean sk;
		private TodayBean today;

		public SkBean getSk() {
			return sk;
		}

		public void setSk(SkBean sk) {
			this.sk = sk;
		}

		public TodayBean getToday() {
			return today;
		}

		public void setToday(TodayBean today) {
			this.today = today;
		}
		public static class SkBean {
			/**
			 * temp : 25
			 * wind_direction : 东北风
			 * wind_strength : 1级
			 * humidity : 71%
			 * time : 19:27
			 */

			private String temp;
			private String wind_direction;
			private String wind_strength;
			private String humidity;
			private String time;

			public String getTemp() {
				return temp;
			}

			public void setTemp(String temp) {
				this.temp = temp;
			}

			public String getWind_direction() {
				return wind_direction;
			}

			public void setWind_direction(String wind_direction) {
				this.wind_direction = wind_direction;
			}

			public String getWind_strength() {
				return wind_strength;
			}

			public void setWind_strength(String wind_strength) {
				this.wind_strength = wind_strength;
			}

			public String getHumidity() {
				return humidity;
			}

			public void setHumidity(String humidity) {
				this.humidity = humidity;
			}

			public String getTime() {
				return time;
			}

			public void setTime(String time) {
				this.time = time;
			}
		}

		public static class TodayBean {
			/**
			 * temperature : 24℃~29℃
			 * weather : 多云转小雨
			 * weather_id : {"fa":"01","fb":"07"}
			 * wind : 东北风4-5 级
			 * week : 星期四
			 * city : 上海
			 * date_y : 2017年09月14日
			 * dressing_index : 舒适
			 * dressing_advice : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
			 * uv_index : 最弱
			 * comfort_index :
			 * wash_index : 不宜
			 * travel_index : 较不宜
			 * exercise_index : 较不宜
			 * drying_index :
			 */

			private String temperature;
			private String weather;
			private WeatherIdBean weather_id;
			private String wind;
			private String week;
			private String city;
			private String date_y;
			private String dressing_index;
			private String dressing_advice;
			private String uv_index;
			private String comfort_index;
			private String wash_index;
			private String travel_index;
			private String exercise_index;
			private String drying_index;

			public String getTemperature() {
				return temperature;
			}

			public void setTemperature(String temperature) {
				this.temperature = temperature;
			}

			public String getWeather() {
				return weather;
			}

			public void setWeather(String weather) {
				this.weather = weather;
			}

			public WeatherIdBean getWeather_id() {
				return weather_id;
			}

			public void setWeather_id(WeatherIdBean weather_id) {
				this.weather_id = weather_id;
			}

			public String getWind() {
				return wind;
			}

			public void setWind(String wind) {
				this.wind = wind;
			}

			public String getWeek() {
				return week;
			}

			public void setWeek(String week) {
				this.week = week;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getDate_y() {
				return date_y;
			}

			public void setDate_y(String date_y) {
				this.date_y = date_y;
			}

			public String getDressing_index() {
				return dressing_index;
			}

			public void setDressing_index(String dressing_index) {
				this.dressing_index = dressing_index;
			}

			public String getDressing_advice() {
				return dressing_advice;
			}

			public void setDressing_advice(String dressing_advice) {
				this.dressing_advice = dressing_advice;
			}

			public String getUv_index() {
				return uv_index;
			}

			public void setUv_index(String uv_index) {
				this.uv_index = uv_index;
			}

			public String getComfort_index() {
				return comfort_index;
			}

			public void setComfort_index(String comfort_index) {
				this.comfort_index = comfort_index;
			}

			public String getWash_index() {
				return wash_index;
			}

			public void setWash_index(String wash_index) {
				this.wash_index = wash_index;
			}

			public String getTravel_index() {
				return travel_index;
			}

			public void setTravel_index(String travel_index) {
				this.travel_index = travel_index;
			}

			public String getExercise_index() {
				return exercise_index;
			}

			public void setExercise_index(String exercise_index) {
				this.exercise_index = exercise_index;
			}

			public String getDrying_index() {
				return drying_index;
			}

			public void setDrying_index(String drying_index) {
				this.drying_index = drying_index;
			}

			public static class WeatherIdBean {
				/**
				 * fa : 01
				 * fb : 07
				 */

				private String fa;
				private String fb;

				public String getFa() {
					return fa;
				}

				public void setFa(String fa) {
					this.fa = fa;
				}

				public String getFb() {
					return fb;
				}

				public void setFb(String fb) {
					this.fb = fb;
				}
			}
		}
	}
}
