/*
 * http://www.ibleaders.co.kr
 * Call (02)2621-2288~9
 *
 *  Copyright 2016 IB LEADERS CO. LTD.
 */
var ibleaders;
ibleaders = ibleaders || {};

ibleaders = {
    /**
     * licenseType
     *
     * enum [ "file", "value" ] default 'value'
     *
     * file로 사용할 경우 licenseType 을 명시하고 해당 프로퍼티 value로 "file" 을 설정한다.
     *
     */
    licenseType: "value",
    /**
     * license
     *
     * licenseType이 "value" 일 경우 라이선스 값을 기입한다.
     * licenseType이 "file" 일 경우 라이선스 파일 명을 기입한다.
     */
    license: "W2FtSztPKC9yajYzYjJxbn9NNREsG2kpcmQ/enQ9Zn49IAF8H3tSJnRtLTNgLWIgf2omSCJdPEVhZCt+N2YscSA1ZXJSOkQlQHA9LyBsKT9zaT42d1c/UDoXY2Qvfj9tZGQscnhySSpRZx82Yg==",// 운영서버
    //license: "W2FtSztPKC9yajYzYjJxbn9NNREsG2kpcmQ/enQ9Zn49IAF8H3tSI3RyNDV/NWU/Y28gViJILBt9cHhkM3o1dz8tYm1OP0I7QGUtcTx4ZWx3aiExf0g5Uw==",// 운영서버
    //license: "W2FtSztPKCZxZDYzYjJxbn8QYkI6RmopdSYxOmkxbzg8aEN+EmNSOnx2d2wtLGQpYWArTz9DKFgkImFgL2Y1dz40aWkIYA8hWWx7MWQwZSl3ayI=",// 개발서버
    /*
     * iborg license value
     *
     * ibleaders.js의 ibleaders.license 를 공용으로 사용할 환경이 되지 않을 경우
     * iborg를 위한 개별 license 를 이곳에 지정한다.
     *
     */
    iborg: {
        /**
         * license
         *
         * licenseType이 "value" 일 경우 라이선스 값을 기입한다.
         * licenseType이 "file" 일 경우 라이선스 파일 명을 기입한다.
         */
    	license: "W2FtSztPKC9yajYzYjJxbn9NNREsG2kpcmQ/enQ9Zn49IAF8H3tSI3RyNDV/NWU/Y28gViJILBt9cHhkM3o1dz8tYm1OP0I7QGUtcTx4dnc0FFJIOkl1UCUUZGwxYTc=" //운영서버
		//license: "W2FtSztPKCZxZDYzYjJxbn8QYkI6RmopdSYxOmkxbzg8aEN+EmNSOnx2d2wtLGQpYWArTz9DKFgkImFgL2Y1dz40aWkIYA83CC1IRx14YCZ1JyQxckkwUCQX" //개발서버

    }
};