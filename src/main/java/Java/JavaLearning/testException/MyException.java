package Java.JavaLearning.testException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/16 0016 23:18
 */
public class MyException extends Exception{
    private String returnCode;//异常对应的返回码
    private String returnMsg;//异常对应的描述信息

    public MyException() {
        super();
    }

    public MyException(String returnMsg) {
        super(returnMsg);
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public MyException(String returnCode, String returnMsg) {
        super();
        this.returnCode=returnCode;
        this.returnMsg=returnMsg;
    }
}
