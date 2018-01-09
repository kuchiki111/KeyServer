package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.Keyconfirm;
import service.KeyconfirmService;

import java.util.ArrayList;
import java.util.List;

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

    //返回表中所有数据
    public String showKeyInfo(){
        List<Keyconfirm> list = keyconfirmService.showRecords();
        returnData = JSONArray.parseArray(JSON.toJSONString(list));
        return  "show";
    }

    //keyId=J33GT-XVVYK-VHBBC-VY7FB-MTQ4C&hddId=8410B3B6-6187-41E1-A6CE-B88D085F4EDC
    //key是否存在，存在做登录操作，不存在做注册操作
    public String keyConfirm(){
        List<String> list = new ArrayList<>();
        list.add("result");
        //keyId是否存在数据库
        if (keyconfirmService.isKeyExist(keyInfo.getKeyId())){
            if (keyconfirmService.Login(keyInfo.getKeyId(),keyInfo.getHddId())){
                list.add("2");//keyId和HddId与数据库中相同，允许激活
            }else {
                list.add("3");//keyId和HddId与数据库中不同，拒绝激活
            }
        }else {
            if(keyconfirmService.Register(keyInfo.getKeyId(),keyInfo.getHddId())){
                list.add("0");//插入新keyId和HddId
            }
            else {
                list.add("1");//插入失败
            }
        }

        returnData = JSONArray.parseArray(JSON.toJSONString(list));
        return "comfirm";
    }

    //增删改，不使用
    public String insert(){
        List<String> list = new ArrayList<>();
        list.add("result");
        list.add(keyconfirmService.doInsert(keyInfo)+"");
        returnData = JSONArray.parseArray(JSON.toJSONString(list));
        return "insert";
    }

    public String delete(){
        List<String> list = new ArrayList<>();
        list.add("result");
        keyInfo = keyconfirmService.findRecordById(keyInfo.getId());
        list.add(keyconfirmService.doDelete(keyInfo)+"");
        returnData = JSONArray.parseArray(JSON.toJSONString(list));
        return "delete";
    }

    public String update(){
        List<String> list = new ArrayList<>();
        list.add("result");
        list.add(keyconfirmService.doUpdate(keyInfo)+"");
        returnData = JSONArray.parseArray(JSON.toJSONString(list));
        return "update";
    }
}
