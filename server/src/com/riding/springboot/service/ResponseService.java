package com.riding.springboot.user.service;

import com.riding.springboot.user.reponse.CommonResult;
import com.riding.springboot.user.reponse.ListResult;
import com.riding.springboot.user.reponse.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

//결과 모델에 데이터를 넣어주는 역할
@Service
public class ResponseService {

    // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
    /*
     * enum?
     * 클래스처럼 보이게 하는 상수
     * 서로 관련 있는 상수들을 모아 심볼릭한 명칭의 집합으로 정의한 것
     */
    public enum CommonResponse {
        SUCCESS(0, "성공."),
        FAIL(-1, "실패");

        int code;
        String msg;

        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    // 단일건 결과 처리 메소드
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);

        return result;
    }

    //다중건 결과 처리 메소드
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        setSuccessResult(result);

        return result;
    }

    // 성공 결과만 처리하는 메소드
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);

        return result;
    }

    // 실패 결과만 처리하는 메소드
    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }

}
