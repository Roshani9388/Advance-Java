package demo.com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CalculateTag extends TagSupport{
	public String num1,num2;

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}
	
	public int doStartTag()
	{
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out=pageContext.getOut();
		try {
			out.println("InMycalculate tag");
		
		out.println("Adding two nums using custom fields");
		int sum=Integer.parseInt(num1)+Integer.parseInt(num2);
		out.println("sum="+sum);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		return EVAL_PAGE;
	}
}
