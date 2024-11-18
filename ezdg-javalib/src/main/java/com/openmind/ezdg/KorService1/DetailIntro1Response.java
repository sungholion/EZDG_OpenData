package com.openmind.ezdg.KorService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class DetailIntro1Response {

    private Response response;

    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;
    }

    @Getter
    @Setter
    public static class Header {
        private Integer resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    public static class Body {
        private String dataType;
        private Items items;
        private String pageNo;
        private String numOfRows;
        private String totalCount;
    }

    @Getter
    @Setter
    public static class Items {
        private List<Item> item;
    }

    @Getter
    @Setter
    public static class Item {
        private String chkcreditcardculture;
        private String scaleleports;
        private String usefeeleports;
        private String discountinfofestival;
        private String chkcreditcardfood;
        private String eventenddate;
        private String playtime;
        private String chkbabycarriageculture;
        private String roomcount;
        private String reservationlodging;
        private String reservationurl;
        private String roomtype;
        private String scalelodging;
        private String subfacility;
        private String barbecue;
        private String beauty;
        private String beverage;
        private String bicycle;
        private String campfire;
        private String fitness;
        private String placeinfo;
        private String parkinglodging;
        private String pickup;
        private String publicbath;
        private String opendate;
        private String parking;
        private String restdate;
        private String usetimeleports;
        private String foodplace;
        private String goodstay;
        private String hanok;
        private String infocenterlodging;
        private String eventhomepage;
        private String eventplace;
        private String parkingleports;
        private String reservation;
        private String restdateleports;
        private String eventstartdate;
        private String festivalgrade;
        private String karaoke;
        private String discountinfofood;
        private String firstmenu;
        private String infocenterfood;
        private String kidsfacility;
        private String opendatefood;
        private String opentimefood;
        private String packing;
        private String parkingfood;
        private String reservationfood;
        private String restdatefood;
        private String scalefood;
        private String seat;
        private String smoking;
        private String treatmenu;
        private String lcnsno;
        private String contentid;
        private String contenttypeid;
        private String accomcount;
        private String chkbabycarriage;
        private String chkcreditcard;
        private String chkpet;
        private String expagerange;
        private String expguide;
        private String heritage1;
        private String heritage2;
        private String heritage3;
        private String infocenter;
        private String taketime;
        private String theme;
        private String accomcountleports;
        private String chkbabycarriageleports;
        private String chkcreditcardleports;
        private String chkpetleports;
        private String expagerangeleports;
        private String infocenterleports;
        private String openperiod;
        private String parkingfeeleports;
        private String program;
        private String spendtimefestival;
        private String sponsor1;
        private String sponsor1tel;
        private String chkpetculture;
        private String discountinfo;
        private String infocenterculture;
        private String parkingculture;
        private String parkingfee;
        private String restdateculture;
        private String usefee;
        private String usetimeculture;
        private String scale;
        private String spendtime;
        private String agelimit;
        private String bookingplace;
        private String useseason;
        private String usetime;
        private String accomcountculture;
        private String sponsor2;
        private String sponsor2tel;
        private String subevent;
        private String usetimefestival;
        private String distance;
        private String infocentertourcourse;
        private String schedule;
        private String publicpc;
        private String sauna;
        private String seminar;
        private String sports;
        private String refundregulation;
        private String chkbabycarriageshopping;
        private String chkcreditcardshopping;
        private String chkpetshopping;
        private String culturecenter;
        private String fairday;
        private String infocentershopping;
        private String opendateshopping;
        private String opentime;
        private String parkingshopping;
        private String restdateshopping;
        private String restroom;
        private String saleitem;
        private String saleitemcost;
        private String scaleshopping;
        private String shopguide;
        private String checkintime;
        private String checkouttime;
        private String chkcooking;
        private String accomcountlodging;
        private String benikia;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Chkcreditcardculture: ").append(this.getChkcreditcardculture()).append("\n");
            sb.append("Scaleleports: ").append(this.getScaleleports()).append("\n");
            sb.append("Usefeeleports: ").append(this.getUsefeeleports()).append("\n");
            sb.append("Discountinfofestival: ").append(this.getDiscountinfofestival()).append("\n");
            sb.append("Chkcreditcardfood: ").append(this.getChkcreditcardfood()).append("\n");
            sb.append("Eventenddate: ").append(this.getEventenddate()).append("\n");
            sb.append("Playtime: ").append(this.getPlaytime()).append("\n");
            sb.append("Chkbabycarriageculture: ").append(this.getChkbabycarriageculture()).append("\n");
            sb.append("Roomcount: ").append(this.getRoomcount()).append("\n");
            sb.append("Reservationlodging: ").append(this.getReservationlodging()).append("\n");
            sb.append("Reservationurl: ").append(this.getReservationurl()).append("\n");
            sb.append("Roomtype: ").append(this.getRoomtype()).append("\n");
            sb.append("Scalelodging: ").append(this.getScalelodging()).append("\n");
            sb.append("Subfacility: ").append(this.getSubfacility()).append("\n");
            sb.append("Barbecue: ").append(this.getBarbecue()).append("\n");
            sb.append("Beauty: ").append(this.getBeauty()).append("\n");
            sb.append("Beverage: ").append(this.getBeverage()).append("\n");
            sb.append("Bicycle: ").append(this.getBicycle()).append("\n");
            sb.append("Campfire: ").append(this.getCampfire()).append("\n");
            sb.append("Fitness: ").append(this.getFitness()).append("\n");
            sb.append("Placeinfo: ").append(this.getPlaceinfo()).append("\n");
            sb.append("Parkinglodging: ").append(this.getParkinglodging()).append("\n");
            sb.append("Pickup: ").append(this.getPickup()).append("\n");
            sb.append("Publicbath: ").append(this.getPublicbath()).append("\n");
            sb.append("Opendate: ").append(this.getOpendate()).append("\n");
            sb.append("Parking: ").append(this.getParking()).append("\n");
            sb.append("Restdate: ").append(this.getRestdate()).append("\n");
            sb.append("Usetimeleports: ").append(this.getUsetimeleports()).append("\n");
            sb.append("Foodplace: ").append(this.getFoodplace()).append("\n");
            sb.append("Goodstay: ").append(this.getGoodstay()).append("\n");
            sb.append("Hanok: ").append(this.getHanok()).append("\n");
            sb.append("Infocenterlodging: ").append(this.getInfocenterlodging()).append("\n");
            sb.append("Eventhomepage: ").append(this.getEventhomepage()).append("\n");
            sb.append("Eventplace: ").append(this.getEventplace()).append("\n");
            sb.append("Parkingleports: ").append(this.getParkingleports()).append("\n");
            sb.append("Reservation: ").append(this.getReservation()).append("\n");
            sb.append("Restdateleports: ").append(this.getRestdateleports()).append("\n");
            sb.append("Eventstartdate: ").append(this.getEventstartdate()).append("\n");
            sb.append("Festivalgrade: ").append(this.getFestivalgrade()).append("\n");
            sb.append("Karaoke: ").append(this.getKaraoke()).append("\n");
            sb.append("Discountinfofood: ").append(this.getDiscountinfofood()).append("\n");
            sb.append("Firstmenu: ").append(this.getFirstmenu()).append("\n");
            sb.append("Infocenterfood: ").append(this.getInfocenterfood()).append("\n");
            sb.append("Kidsfacility: ").append(this.getKidsfacility()).append("\n");
            sb.append("Opendatefood: ").append(this.getOpendatefood()).append("\n");
            sb.append("Opentimefood: ").append(this.getOpentimefood()).append("\n");
            sb.append("Packing: ").append(this.getPacking()).append("\n");
            sb.append("Parkingfood: ").append(this.getParkingfood()).append("\n");
            sb.append("Reservationfood: ").append(this.getReservationfood()).append("\n");
            sb.append("Restdatefood: ").append(this.getRestdatefood()).append("\n");
            sb.append("Scalefood: ").append(this.getScalefood()).append("\n");
            sb.append("Seat: ").append(this.getSeat()).append("\n");
            sb.append("Smoking: ").append(this.getSmoking()).append("\n");
            sb.append("Treatmenu: ").append(this.getTreatmenu()).append("\n");
            sb.append("Lcnsno: ").append(this.getLcnsno()).append("\n");
            sb.append("Contentid: ").append(this.getContentid()).append("\n");
            sb.append("Contenttypeid: ").append(this.getContenttypeid()).append("\n");
            sb.append("Accomcount: ").append(this.getAccomcount()).append("\n");
            sb.append("Chkbabycarriage: ").append(this.getChkbabycarriage()).append("\n");
            sb.append("Chkcreditcard: ").append(this.getChkcreditcard()).append("\n");
            sb.append("Chkpet: ").append(this.getChkpet()).append("\n");
            sb.append("Expagerange: ").append(this.getExpagerange()).append("\n");
            sb.append("Expguide: ").append(this.getExpguide()).append("\n");
            sb.append("Heritage1: ").append(this.getHeritage1()).append("\n");
            sb.append("Heritage2: ").append(this.getHeritage2()).append("\n");
            sb.append("Heritage3: ").append(this.getHeritage3()).append("\n");
            sb.append("Infocenter: ").append(this.getInfocenter()).append("\n");
            sb.append("Taketime: ").append(this.getTaketime()).append("\n");
            sb.append("Theme: ").append(this.getTheme()).append("\n");
            sb.append("Accomcountleports: ").append(this.getAccomcountleports()).append("\n");
            sb.append("Chkbabycarriageleports: ").append(this.getChkbabycarriageleports()).append("\n");
            sb.append("Chkcreditcardleports: ").append(this.getChkcreditcardleports()).append("\n");
            sb.append("Chkpetleports: ").append(this.getChkpetleports()).append("\n");
            sb.append("Expagerangeleports: ").append(this.getExpagerangeleports()).append("\n");
            sb.append("Infocenterleports: ").append(this.getInfocenterleports()).append("\n");
            sb.append("Openperiod: ").append(this.getOpenperiod()).append("\n");
            sb.append("Parkingfeeleports: ").append(this.getParkingfeeleports()).append("\n");
            sb.append("Program: ").append(this.getProgram()).append("\n");
            sb.append("Spendtimefestival: ").append(this.getSpendtimefestival()).append("\n");
            sb.append("Sponsor1: ").append(this.getSponsor1()).append("\n");
            sb.append("Sponsor1tel: ").append(this.getSponsor1tel()).append("\n");
            sb.append("Chkpetculture: ").append(this.getChkpetculture()).append("\n");
            sb.append("Discountinfo: ").append(this.getDiscountinfo()).append("\n");
            sb.append("Infocenterculture: ").append(this.getInfocenterculture()).append("\n");
            sb.append("Parkingculture: ").append(this.getParkingculture()).append("\n");
            sb.append("Parkingfee: ").append(this.getParkingfee()).append("\n");
            sb.append("Restdateculture: ").append(this.getRestdateculture()).append("\n");
            sb.append("Usefee: ").append(this.getUsefee()).append("\n");
            sb.append("Usetimeculture: ").append(this.getUsetimeculture()).append("\n");
            sb.append("Scale: ").append(this.getScale()).append("\n");
            sb.append("Spendtime: ").append(this.getSpendtime()).append("\n");
            sb.append("Agelimit: ").append(this.getAgelimit()).append("\n");
            sb.append("Bookingplace: ").append(this.getBookingplace()).append("\n");
            sb.append("Useseason: ").append(this.getUseseason()).append("\n");
            sb.append("Usetime: ").append(this.getUsetime()).append("\n");
            sb.append("Accomcountculture: ").append(this.getAccomcountculture()).append("\n");
            sb.append("Sponsor2: ").append(this.getSponsor2()).append("\n");
            sb.append("Sponsor2tel: ").append(this.getSponsor2tel()).append("\n");
            sb.append("Subevent: ").append(this.getSubevent()).append("\n");
            sb.append("Usetimefestival: ").append(this.getUsetimefestival()).append("\n");
            sb.append("Distance: ").append(this.getDistance()).append("\n");
            sb.append("Infocentertourcourse: ").append(this.getInfocentertourcourse()).append("\n");
            sb.append("Schedule: ").append(this.getSchedule()).append("\n");
            sb.append("Publicpc: ").append(this.getPublicpc()).append("\n");
            sb.append("Sauna: ").append(this.getSauna()).append("\n");
            sb.append("Seminar: ").append(this.getSeminar()).append("\n");
            sb.append("Sports: ").append(this.getSports()).append("\n");
            sb.append("Refundregulation: ").append(this.getRefundregulation()).append("\n");
            sb.append("Chkbabycarriageshopping: ").append(this.getChkbabycarriageshopping()).append("\n");
            sb.append("Chkcreditcardshopping: ").append(this.getChkcreditcardshopping()).append("\n");
            sb.append("Chkpetshopping: ").append(this.getChkpetshopping()).append("\n");
            sb.append("Culturecenter: ").append(this.getCulturecenter()).append("\n");
            sb.append("Fairday: ").append(this.getFairday()).append("\n");
            sb.append("Infocentershopping: ").append(this.getInfocentershopping()).append("\n");
            sb.append("Opendateshopping: ").append(this.getOpendateshopping()).append("\n");
            sb.append("Opentime: ").append(this.getOpentime()).append("\n");
            sb.append("Parkingshopping: ").append(this.getParkingshopping()).append("\n");
            sb.append("Restdateshopping: ").append(this.getRestdateshopping()).append("\n");
            sb.append("Restroom: ").append(this.getRestroom()).append("\n");
            sb.append("Saleitem: ").append(this.getSaleitem()).append("\n");
            sb.append("Saleitemcost: ").append(this.getSaleitemcost()).append("\n");
            sb.append("Scaleshopping: ").append(this.getScaleshopping()).append("\n");
            sb.append("Shopguide: ").append(this.getShopguide()).append("\n");
            sb.append("Checkintime: ").append(this.getCheckintime()).append("\n");
            sb.append("Checkouttime: ").append(this.getCheckouttime()).append("\n");
            sb.append("Chkcooking: ").append(this.getChkcooking()).append("\n");
            sb.append("Accomcountlodging: ").append(this.getAccomcountlodging()).append("\n");
            sb.append("Benikia: ").append(this.getBenikia()).append("\n");
            sb.append("-----------------------\n");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
             return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }
}