package VilageFcstInfoService;

import com.openmind.ezdg.generate.library.openapi.AbstractAPI;
import java.util.List;

public class VilagefcstinfoserviceAPI extends AbstractAPI<VilagefcstinfoserviceResponse> {

    public VilagefcstinfoserviceAPI() {
    super("/getUltraSrtNcst");
    }

        /**
        * 공공데이터포털에서 받은 인증키
        */
        public VilagefcstinfoserviceAPI ServiceKey(String ServiceKey) {
        uriBuilder.setParameter("ServiceKey", String.valueOf(ServiceKey));
        return this;
        }
        /**
        * 페이지번호
        */
        public VilagefcstinfoserviceAPI pageNo(Integer pageNo) {
        uriBuilder.setParameter("pageNo", String.valueOf(pageNo));
        return this;
        }
        /**
        * 한 페이지 결과 수
        */
        public VilagefcstinfoserviceAPI numOfRows(Integer numOfRows) {
        uriBuilder.setParameter("numOfRows", String.valueOf(numOfRows));
        return this;
        }
        /**
        * 요청자료형식(XML/JSON) Default: XML
        */
        public VilagefcstinfoserviceAPI dataType(String dataType) {
        uriBuilder.setParameter("dataType", String.valueOf(dataType));
        return this;
        }
        /**
        * ‘21년 6월 28일 발표
        */
        public VilagefcstinfoserviceAPI base_date(Integer base_date) {
        uriBuilder.setParameter("base_date", String.valueOf(base_date));
        return this;
        }
        /**
        * 06시 발표(정시단위)
        */
        public VilagefcstinfoserviceAPI base_time(Integer base_time) {
        uriBuilder.setParameter("base_time", String.valueOf(base_time));
        return this;
        }
        /**
        * 예보지점의 X 좌표값
        */
        public VilagefcstinfoserviceAPI nx(Integer nx) {
        uriBuilder.setParameter("nx", String.valueOf(nx));
        return this;
        }
        /**
        * 예보지점의 Y 좌표값
        */
        public VilagefcstinfoserviceAPI ny(Integer ny) {
        uriBuilder.setParameter("ny", String.valueOf(ny));
        return this;
        }

    // fetch 메서드는 예외를 던지지 않도록 수정
    public List<VilagefcstinfoserviceResponse> fetch() {
        return super.fetch();
        }
        }
