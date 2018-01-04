package action;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.Keyconfirm;
import service.KeyconfirmService;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/4
 * Time: 10:06
 */
public class KeyconfirmAction extends ActionSupport implements ModelDriven<Keyconfirm> {

    private Keyconfirm keyInfo = new Keyconfirm();
    private KeyconfirmService keyconfirmService;
    private JSONArray returnData;

    public void setKeyconfirmService(KeyconfirmService keyconfirmService) {
        this.keyconfirmService = keyconfirmService;
    }

    public JSONArray getReturnData() {
        return returnData;
    }

    public void setReturnData(JSONArray returnData) {
        this.returnData = returnData;
    }

    public Keyconfirm getKeyInfo() {
        return keyInfo;
    }

    public void setKeyInfo(Keyconfirm keyInfo) {
        this.keyInfo = keyInfo;
    }

    @Override
    public Keyconfirm getModel() {
        if (keyInfo == null){
            keyInfo = new Keyconfirm();
        }
        return keyInfo;
    }

}
