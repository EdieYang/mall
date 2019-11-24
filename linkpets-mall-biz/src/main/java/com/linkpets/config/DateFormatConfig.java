package com.linkpets.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.StdDateFormat;

/**
 * 全局日期格式化
 *
 * @author wando
 *
 */
@JsonComponent
public class DateFormatConfig {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
		/**
		 *
		 */
		private static final long serialVersionUID = 8104638570625137300L;

		@Override
		public Date parse(String source) throws ParseException {
			try {
				if (StringUtils.isEmpty(source)) {
					return null;
				}
				return super.parse(source);
			} catch (Exception e) {
				return new StdDateFormat().parse(source);
			}
		}
	};

//    private static UserController userController;//这里是指获取当前登录人的工具类

//    @Autowired
//    public void setUserController(UserController userController) {
//        DateFormatConfig.userController = userController;
//    }

	/**
	 * 日期格式化
	 */
	public static class DateJsonSerializer extends JsonSerializer<Date> {
		@Override
		public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
				throws IOException {
			// 获取当前登录人的所属时区
			dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//			System.out.println(" 日期格式化" + dateFormat.format(date));
			// 格式化日期
			jsonGenerator.writeString(dateFormat.format(date).replace(" 00:00:00", ""));
		}
	}

	/**
	 * 解析日期字符串
	 */
	public static class DateJsonDeserializer extends JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
				throws IOException, JsonProcessingException {
			try {
				// 获取当前登录人的所属时区
				dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//				System.out.println("解析日期字符串" + jsonParser.getCurrentName() + jsonParser.getText());
				// 解析日期
				return dateFormat.parse(jsonParser.getText());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}

		}
	}
}
