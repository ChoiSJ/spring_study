<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="/jhta/resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script type="text/javascript" src="/jhta/resources/jquery/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/jhta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
   $(function() {

       //전체 보강 신청 값 가져오기

       //보강 신청 조회
       $("button[id^='lectureApplication']").on("click", function() {

           var $modalApplecation = $("#modalApplecation").empty();

           var subjectNo = $(this).attr("id").replace("lectureApplication-", "");
           console.log(subjectNo);

           $.ajax({
               type: "GET",
               url: "makeupLessonRegisterSelect/" + subjectNo,
               dataType: "json",
               success: function(data) {

                   var professorId = data.professorId;
                   var subjectNo = data.subjectNo;
                   var majorCode = data.majorCode;
                   var subjectName = data.subjectName;
                   var professorName = data.professorName;
                   var supplementLectureCheck = data.supplementLectureCheck;
                   var professorNumber = data.professorNumber;
                   var majorOption = data.majorOption;
                   var majorScore = data.majorScore;
                   var subjectLectureNumber = data.subjectLectureNumber;
                   var subjectTime = data.subjectTime;
                   var subjectDate = data.subjectDate;
                   var supplementLectureCheck = data.supplementLectureCheck;
                   var makeupLessonRegister = data.makeupLessonRegister;

                   var $modalApplecation = $("#modalApplecation").empty();

                   var html = '<div class="modal-header">';
                   html += '<h4 class="modal-title" id="gridSystemModalLabel">휴강 신청</h4>';
                   html += '</div>';
                   html += '<div class="modal-body">';
                   html += '<div class="container">';
                   html += '<form class="form-horizontal" id="applicationInformation">';
                   html += '<div class="col-sm-5">';
                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">교수 ID:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorId" value="' + professorId + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">교수 번호:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorNumber" value="' + professorNumber + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">학과 번호:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorCode" value="' + majorCode + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">과목 번호:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectNo" value="' + subjectNo + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">과목 이름:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectName" value="' + subjectName + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';
                   html += '</div>';

                   html += '<div class="col-sm-7">';
                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">과목 학점:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorScore" value="' + majorScore + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">교수 이름:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorName" value="' + professorName + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">전공 옵션:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorOption" value="' + majorOption + '" disabled="disabled" />';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">과목 시간:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectTime" value="' + subjectTime + '" disabled="disabled"/>';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '<div class="form-group">';
                   html += '<div class="col-sm-3">';
                   html += '<label class="pull-right" style="color: black">과목 날짜:</label>';
                   html += '</div>';
                   html += '<div class="col-sm-6">';
                   html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectDate" value="' + subjectDate + '" disabled="disabled"/>';
                   html += '</div>';
                   html += '<div class="col-sm-3"></div>';
                   html += '</div>';

                   html += '</div>';
                   html += '</div>';
                   html += '</div>';
                   html += '</div>';
                   html += '<div class="modal-footer">';
                   html += '<input hidden="hidden" name="makeupLessonRegister" value="' + makeupLessonRegister + '">';
                   html += '<button id="supplementLectureApplicationAdd-' + subjectNo + '"type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>';
                   html += '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
                   html += '</div>';

                   $modalApplecation.append(html);

                   //휴강 신청 버튼 처리
                   $("button[id^='supplementLectureApplicationAdd-']").on("click", function() {

                       var register = $(":input[name='supplementLectureCheck']").val()

                       var userInformaiton = {
                           professorId: $(":input[name='professorId']").val(),
                           professorNumber: $(":input[name='professorNumber']").val(),
                           majorCode: $(":input[name='majorCode']").val(),
                           subjectNo: $(":input[name='subjectNo']").val(),
                           subjectName: $(":input[name='subjectName']").val(),
                           majorScore: $(":input[name='majorScore']").val(),
                           professorName: $(":input[name='professorName']").val(),
                           majorOption: $(":input[name='majorOption']").val(),
                           subjectTime: $(":input[name='subjectTime']").val(),
                           subjectDate: $(":input[name='subjectDate']").val(),
                           makeupLessonRegister: $(":input[name='makeupLessonRegister']").attr("value").replace("n", "y")
                       }

                       var buttonNo = $(":input[name='subjectNo']").val()
                       console.log(subjectNo)

                       $.ajax({
                           type: "POST",
                           url: "makeupLessonUser/",
                           contentType: "application/json", //서버로 보내는 컨텐츠 형식 정의
                           data: JSON.stringify(userInformaiton),
                           success: function(data) {

                               var subjectNo = data.subjectNo;
                               console.log(subjectNo);
                               //신청 번호 취소로 바꾸는 코딩
                               if (buttonNo == subjectNo) {

                                   $("#supplementLectureTr-" + subjectNo + "").empty();

                                   var $table = $("#subjectListaddList");

                                   var professorId = data.professorId;
                                   var subjectNo = data.subjectNo;
                                   var majorCode = data.majorCode;
                                   var subjectName = data.subjectName;
                                   var professorName = data.professorName;
                                   var makeupLessonRegister = data.makeupLessonRegister;
                                   var professorNumber = data.professorNumber;
                                   var majorOption = data.majorOption;
                                   var majorScore = data.majorScore;
                                   var subjectLectureNumber = data.subjectLectureNumber;

                                   var html = '<tr id="supplementLectureTr-' + subjectNo + '">';
                                   html += '<td style="width: 10%" id="id-' + professorId + '"><label>' + professorId + '</label></td>'
                                   html += '<td style="width: 10%" id="code-' + majorCode + '"><label>' + majorCode + '</label></td>';
                                   html += '<td style="width: 15%" id="subjectNo-' + subjectNo + '"><label>' + subjectNo + '</label></td>';
                                   html += '<td style="width: 15%" id="majorOption' + majorOption + '"><label>' + majorOption + '</label></td>';
                                   html += '<td style="width: 15%" id="professorName-' + professorName + '"><label>' + professorName + '</label></td>';
                                   html += '<td style="width: 25%" id="subjectName-' + subjectName + '"><label>' + subjectName + '</label></td>';
                                   html += '<td style="width: 20%" id="cancleButton">';
                                   html += '<button id="supplementLectureCancle-' + subjectNo + '" class="mdl-button mdl-js-button mdl-button--accent">';
                                   html += '<i class="glyphicon glyphicon-remove-circle">취소</i>';
                                   html += '</button>';
                                   html += '</td>';
                                   html += '</tr>';

                                   $table.append(html);


                               }

                               //취소 처리
                               $("button[id^=supplementLectureCancle-]").on("click", function() {

                                   var subjectNo = $(this).attr("id").replace("supplementLectureCancle-", "");

                                   $.ajax({
                                       type: "DELETE",
                                       url: "makeupCancle/" + subjectNo,
                                       dataType: 'json',
                                       success: function(data) {

                                           var dataNo = data.subjectNo;

                                           $("td:contains(" + dataNo + ")").parents("tr").hide();

                                       }
                                   });
                               });




                           }
                       });
                   });




               }
           });
       });




       //college 조회
       $("#collegeCode").on("change", function() {

           var collegeCode = $(this).val();
           console.log(collegeCode);

           $.ajax({
               type: "GET",
               url: "makeuplessoncollege/" + collegeCode,
               dataType: "json",
               success: function(data) {

                   if (collegeCode == 0) {

                       var $selectCollege = $("#majorList").empty();

                       var html = '<option>--선택하세요--</option>';

                       $selectCollege.append(html);

                   } else {

                       var $selectCollege = $("#majorList").empty();

                       var option = '<option>--선택하세요--</option>';
                       $selectCollege.append(option);

                       for (i = 0; i < data.length; i++) {

                           var collegeName = data[i].collegeName;
                           var collegeCode = data[i].collegeCode;

                           var html = '<option value="' + collegeCode + '">' + collegeName + '</option>';

                           $selectCollege.append(html);
                       }
                   }

                   //학과 조회한것 중에 
                   $("#majorList").on("change", function() {

                       var majorCode = $(this).val();

                       $.ajax({
                           type: "GET",
                           url: "makeupLessonSearchTable/" + majorCode,
                           datatype: "json",
                           success: function(data) {


                               if (!data.length == 0) {

                                   var $tbody = $("#subjectList").empty();

                                   for (i = 0; i < data.length; i++) {

                                       var professorId = data[i].professorId;
                                       var subjectNo = data[i].subjectNo;
                                       var majorCode = data[i].majorCode;
                                       var subjectName = data[i].subjectName;
                                       var professorName = data[i].professorName;
                                       var supplementLectureCheck = data[i].supplementLectureCheck;
                                       var professorNumber = data[i].professorNumber;
                                       var majorOption = data[i].majorOption;
                                       var majorScore = data[i].majorScore;
                                       var makeupLessonRegister = data[i].makeupLessonRegister;

                                       var html = '<tr id="supplementLectureTr-' + subjectNo + '">';
                                       html += '<td style="width: 10%" id="id-' + professorId + '"><label>' + professorId + '</label></td>'
                                       html += '<td style="width: 10%" id="code-' + majorCode + '"><label>' + majorCode + '</label></td>';
                                       html += '<td style="width: 15%" id="subjectNo-' + subjectNo + '"><label>' + subjectNo + '</label></td>';
                                       html += '<td style="width: 15%" id="majorOption' + majorOption + '"><label>' + majorOption + '</label></td>';
                                       html += '<td style="width: 15%" id="professorName-' + professorName + '"><label>' + professorName + '</label></td>';
                                       html += '<td style="width: 25%" id="subjectName-' + subjectName + '"><label>' + subjectName + '</label></td>';

                                       if (makeupLessonRegister == 'n') {

                                           html += '<td style="width: 15%" id="applicationButton-' + subjectNo + '">';
                                           html += '<button id="lectureApplication-' + subjectNo + '"class="mdl-button mdl-js-button mdl-button--primary" data-toggle="modal" data-target=".bs-example-modal-lg">';
                                           html += '<i class="glyphicon glyphicon-ok-circle">신청</i>';
                                           html += '</button>';
                                           html += '</td>';

                                       }

                                       if (makeupLessonRegister == 'y') {

                                           html += '<td style="width: 20%" id="cancleButton">';
                                           html += '<button id="lectureCancle-' + subjectNo + '" class="mdl-button mdl-js-button mdl-button--accent" data-toggle="modal" data-target=".bs-example-modal-lg">';
                                           html += '<i class="glyphicon glyphicon-remove-circle">취소</i>';
                                           html += '</button>';
                                           html += '</td>';
                                       }

                                       html += '</tr>';

                                       $tbody.append(html);

                                   }

                               } else {

                                   var $tbody = $("#subjectList").empty();

                                   var html = '<tr>';
                                   html += '<td colspan="5">요청하신 정보가 존재 하지 않습니다.</td>';
                                   html += '</tr>';

                                   $tbody.append(html);
                               }

                               //보강 신청 조회
                               $("button[id^='lectureApplication']").on("click", function() {

                                   var $modalApplecation = $("#modalApplecation").empty();

                                   var subjectNo = $(this).attr("id").replace("lectureApplication-", "");
                                   console.log(subjectNo);

                                   $.ajax({
                                       type: "GET",
                                       url: "makeupLessonRegisterSelect/" + subjectNo,
                                       dataType: "json",
                                       success: function(data) {

                                           var professorId = data.professorId;
                                           var subjectNo = data.subjectNo;
                                           var majorCode = data.majorCode;
                                           var subjectName = data.subjectName;
                                           var professorName = data.professorName;
                                           var supplementLectureCheck = data.supplementLectureCheck;
                                           var professorNumber = data.professorNumber;
                                           var majorOption = data.majorOption;
                                           var majorScore = data.majorScore;
                                           var subjectLectureNumber = data.subjectLectureNumber;
                                           var subjectTime = data.subjectTime;
                                           var subjectDate = data.subjectDate;
                                           var supplementLectureCheck = data.supplementLectureCheck;
                                           var makeupLessonRegister = data.makeupLessonRegister;

                                           var $modalApplecation = $("#modalApplecation").empty();

                                           var html = '<div class="modal-header">';
                                           html += '<h4 class="modal-title" id="gridSystemModalLabel">휴강 신청</h4>';
                                           html += '</div>';
                                           html += '<div class="modal-body">';
                                           html += '<div class="container">';
                                           html += '<form class="form-horizontal" id="applicationInformation">';
                                           html += '<div class="col-sm-5">';
                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">교수 ID:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorId" value="' + professorId + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">교수 번호:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorNumber" value="' + professorNumber + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">학과 번호:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorCode" value="' + majorCode + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">과목 번호:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectNo" value="' + subjectNo + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">과목 이름:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectName" value="' + subjectName + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';
                                           html += '</div>';

                                           html += '<div class="col-sm-7">';
                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">과목 학점:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorScore" value="' + majorScore + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">교수 이름:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="professorName" value="' + professorName + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">전공 옵션:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="majorOption" value="' + majorOption + '" disabled="disabled" />';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">과목 시간:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectTime" value="' + subjectTime + '" disabled="disabled"/>';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '<div class="form-group">';
                                           html += '<div class="col-sm-3">';
                                           html += '<label class="pull-right" style="color: black">과목 날짜:</label>';
                                           html += '</div>';
                                           html += '<div class="col-sm-6">';
                                           html += '<input id="code" class="mdl-textfield__input" type="text"style="width: 200px" name="subjectDate" value="' + subjectDate + '" disabled="disabled"/>';
                                           html += '</div>';
                                           html += '<div class="col-sm-3"></div>';
                                           html += '</div>';

                                           html += '</div>';
                                           html += '</div>';
                                           html += '</div>';
                                           html += '</div>';
                                           html += '<div class="modal-footer">';
                                           html += '<input hidden="hidden" name="makeupLessonRegister" value="' + makeupLessonRegister + '">';
                                           html += '<button id="supplementLectureApplicationAdd-' + subjectNo + '"type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>';
                                           html += '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
                                           html += '</div>';

                                           $modalApplecation.append(html);

                                           //휴강 신청 버튼 처리
                                           $("button[id^='supplementLectureApplicationAdd-']").on("click", function() {

                                               var register = $(":input[name='supplementLectureCheck']").val()

                                               var userInformaiton = {
                                                   professorId: $(":input[name='professorId']").val(),
                                                   professorNumber: $(":input[name='professorNumber']").val(),
                                                   majorCode: $(":input[name='majorCode']").val(),
                                                   subjectNo: $(":input[name='subjectNo']").val(),
                                                   subjectName: $(":input[name='subjectName']").val(),
                                                   majorScore: $(":input[name='majorScore']").val(),
                                                   professorName: $(":input[name='professorName']").val(),
                                                   majorOption: $(":input[name='majorOption']").val(),
                                                   subjectTime: $(":input[name='subjectTime']").val(),
                                                   subjectDate: $(":input[name='subjectDate']").val(),
                                                   makeupLessonRegister: $(":input[name='makeupLessonRegister']").attr("value").replace("n", "y")
                                               }

                                               var buttonNo = $(":input[name='subjectNo']").val()
                                               console.log(subjectNo)

                                               $.ajax({
                                                   type: "POST",
                                                   url: "makeupLessonUser/",
                                                   contentType: "application/json", //서버로 보내는 컨텐츠 형식 정의
                                                   data: JSON.stringify(userInformaiton),
                                                   success: function(data) {

                                                       var subjectNo = data.subjectNo;
                                                       console.log(subjectNo);
                                                       //신청 번호 취소로 바꾸는 코딩
                                                       if (buttonNo == subjectNo) {

                                                           $("#supplementLectureTr-" + subjectNo + "").empty();

                                                           var $table = $("#subjectListaddList");

                                                           var professorId = data.professorId;
                                                           var subjectNo = data.subjectNo;
                                                           var majorCode = data.majorCode;
                                                           var subjectName = data.subjectName;
                                                           var professorName = data.professorName;
                                                           var makeupLessonRegister = data.makeupLessonRegister;
                                                           var professorNumber = data.professorNumber;
                                                           var majorOption = data.majorOption;
                                                           var majorScore = data.majorScore;
                                                           var subjectLectureNumber = data.subjectLectureNumber;

                                                           var html = '<tr id="supplementLectureTr-' + subjectNo + '">';
                                                           html += '<td style="width: 10%" id="id-' + professorId + '"><label>' + professorId + '</label></td>'
                                                           html += '<td style="width: 10%" id="code-' + majorCode + '"><label>' + majorCode + '</label></td>';
                                                           html += '<td style="width: 15%" id="subjectNo-' + subjectNo + '"><label>' + subjectNo + '</label></td>';
                                                           html += '<td style="width: 15%" id="majorOption' + majorOption + '"><label>' + majorOption + '</label></td>';
                                                           html += '<td style="width: 15%" id="professorName-' + professorName + '"><label>' + professorName + '</label></td>';
                                                           html += '<td style="width: 25%" id="subjectName-' + subjectName + '"><label>' + subjectName + '</label></td>';
                                                           html += '<td style="width: 20%" id="cancleButton">';
                                                           html += '<button id="supplementLectureCancle-' + subjectNo + '" class="mdl-button mdl-js-button mdl-button--accent">';
                                                           html += '<i class="glyphicon glyphicon-remove-circle">취소</i>';
                                                           html += '</button>';
                                                           html += '</td>';
                                                           html += '</tr>';

                                                           $table.append(html);


                                                       }

                                                       //취소 처리
                                                       $("button[id^=supplementLectureCancle-]").on("click", function() {

                                                           var subjectNo = $(this).attr("id").replace("supplementLectureCancle-", "");

                                                           $.ajax({
                                                               type: "DELETE",
                                                               url: "makeupCancle/" + subjectNo,
                                                               dataType: 'json',
                                                               success: function(data) {

                                                                   var dataNo = data.subjectNo;

                                                                   $("td:contains(" + dataNo + ")").parents("tr").hide();

                                                               }
                                                           });
                                                       });




                                                   }
                                               });
                                           });




                                       }
                                   });
                               });




                           }
                       });
                   });




               }
           });
       });




       //상세 검색
       $("input[id^=searchdatil-]").on("click", function() {


           var searchType = $("input[name='searchdatil']:checked").attr("id").replace("searchdatil-", "");


           var searchButton = $("#search-button-type").attr("value", searchType);


       });




       //상세 정보 조회
       $("#search-button-type").on("click", function(event) {

           event.preventDefault();
           $("#subjectList tr").hide();

           var searchText = $("#searchText").val();
           var searchValue = $("#search-button-type").val();
           console.log("검색:" + searchText);
           console.log("타입:" + searchValue);



           if (searchValue == 'id') {
               $("td:contains(" + searchText + ")").parents("tr").show();
               if ($("td:contains(" + searchText + ")").length == 0) {

               }

           } else if (searchValue == 'name') {
               $("td:contains(" + searchText + ")").parents("tr").show();

           } else if (searchValue == 'subjectNo') {
               $("td:contains(" + searchText + ")").parents("tr").show();

           }
       });




       //쪽지관련 자바스크립트

       $("#receiver-box").on("click", "span", function() {
           var spanNo = $(this).attr("id").replace("name-", "");

           $("input:hidden[name='receiver']").each(function(index, item) {
               var hiddenNo = $(item).attr("id").replace("message-", "");

               if (spanNo == hiddenNo) {
                   $("span[id='name-" + spanNo + "']").remove();
                   $("input:hidden[id='message-" + hiddenNo + "']").remove();
               }
           })
       }).css("cursor", "pointer");

       // 추가를 눌렀을 때 받는사람의 아이디값을 추가하는 코드
       $("#add-list").click(function(event) {
           event.preventDefault();
           var id = $("tr[class='active'] td:eq(0)").text();
           var name = $("tr[class='active'] td:eq(1)").text();

           // 같은 사람을 두 번 등록하는 것을 체크하는 코드
           $("span[class='badge']").each(function(index, item) {
               var spanNo = $(item).attr("id").replace("name-", "");

               if (id == spanNo) {
                   alert("이미 추가되어 있는 유저입니다.");
                   id = false;
                   return false;
               }
           });

           if (name && id) {
               $("#receiver-box").append("<span class='badge' id='name-" + id + "'>" + name + "</span> ");
               $("#message-form").append("<input type='hidden' name='receiver' value='" + id + "' id='message-" + id + "'>");
           }

           $(".modal-body tbody").empty();
           $("#search-word").val("");

           $(this).attr("data-dismiss", "modal");
       });

       $("#search-list").click(function(event) {
           event.preventDefault();

           checkedRadio = $(":radio:checked").val();
           searchWord = $("#search-word").val();
           searchOption = $("#option").val();

           // 학생, 교수 분류와 이름을 검색했을 때 검색결과를 표시하는 ajax 코드
           $.get("adminsearch", {
               checkedRadio: checkedRadio,
               searchWord: searchWord,
               searchOption: searchOption
           }, function(data) {
               $(".modal-body thead").empty();
               $(".modal-body tbody").empty();

               if (searchOption == "name") {
                   $(".modal-body thead").append("<tr><th>학번</th><th>이름</th><th>전화번호</th><th>메일주소</th></tr>");
               } else if (searchOption == "division") {
                   $(".modal-body thead").append("<tr><th>학과코드</th><th>학과명</th></tr>");
               } else if (searchOption == "subject") {
                   $(".modal-body thead").append("<tr><th style='display: none;'>번호</th><th>과목명</th><th>교수명</th><th>학점</th></tr>");
               }
               console.log(data);

               for (var i = 0; i < data.length; i++) {
                   var tr = "<tr></tr>";

                   if (searchOption == "name") {
                       tr = $(tr).append("<td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].phone + "</td><td>" + data[i].email + "</td>");
                       $(".modal-body tbody").append(tr);
                   } else if (searchOption == "division") {
                       tr = $(tr).append("<td>" + data[i].code + "</td><td>" + data[i].name + "</td>");
                       $(".modal-body tbody").append(tr);
                   } else if (searchOption == "subject") {
                       tr = $(tr).append("<td style='display: none;'>" + data[i].no + "</td><td>" + data[i].subjectName + "</td><td>" + data[i].professor.name + "</td><td>" + data[i].score + "</td>");
                       $(".modal-body tbody").append(tr);
                   }
               }
           }, "json");
       });

       // 검색된 행을 클릭했을 때 활성화 시키는 코드
       $(".modal-body tbody").on("click", "tr", function() {
           if ($(this).attr("class")) {
               $(this).removeClass("active");
           } else {
               $(this).addClass("active").siblings().removeClass("active");
           }
       })

       // 모달을 닫을 때 입력 데이터를 없애는 코드
       $("#close-modal").click(function() {
           $(".modal-body thead").empty();
           $(".modal-body tbody").empty();
           $("#search-word").val("");
       });

       $("#send-button").click(function() {
           if (!$("#receiver-box").text().trim()) {
               alert("받는사람을 추가해주세요.");
               return false;
           }
       });

   });
</script>
<style>
   .wrap_table {
       padding: 30px 0;
       position: relative;
       width: 1170px;
   }

   .wrap_table>div {
       overflow: auto;
       height: 200px;
   }

   .wrap_table table {
       width: 1155px;
   }

   .wrap_table table caption {
       height: 0;
       overflow: hidden;
   }

   .wrap_table table thead,
   .wrap_table table tfoot {
       position: absolute;
       display: table;
       width: 1155px;
       ;
       border-bottom: 1px solid #ccc;
   }

   .wrap_table table thead {
       top: 0;
   }

   .wrap_table table tfoot {
       bottom: 0;
   }

   .wrap_table table th,
   .wrap_table table td {
       text-align: center;
       border-right: 1px solid #ccc;
       border-top: 1px solid #ccc;
       height: 30px;
       vertical-align: middle;
   }

   .wrap_table table tr th:first-child,
   .wrap_table table tr td:first-child {
       border-left: 1px solid #ccc;
   }

   .wrap_table table tbody tr:first-child td {
       border-top: 0;
   }
</style>
<title>보강 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp"%>
	<%@ include file="/WEB-INF/views/navi/sidebarsupplementmakeuplesson.jsp"%>
	<!-- 보강신청, 취소 모달 -->
	<div class="container">
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content" id="modalApplecation"></div>
			</div>
		</div>
		<h3>보강 관리</h3>
		<hr />
		<div class="row">
			<h4>&nbsp;&nbsp;&nbsp;보강 신청</h4>
			<div class="col-sm-1">
				<a href="makeuplecturereset.do"><i class="material-icons" style="color: black">restore_page</i></a>
			</div>
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
				<select class="form-control" id="collegeCode">
					<option value="0">--선택하세요.--</option>
					<option value="SO2000">사회대학</option>
					<option value="NS3000">자연과학대학</option>
					<option value="BS4000">생명과학대학</option>
					<option value="ST5000">과학기술대학</option>
					<option value="CA6000">문화예술대학</option>
					<option value="HU1000">인문대학</option>
				</select>
			</div>
			<form action="">
				<div class="col-sm-3">
					<select class="form-control" id="majorList">
						<option>--선택하세요--</option>
					</select>
				</div>
				<div class="col-sm-1"></div>
			</form>
		</div>
		<div class="row" style="height: 20px"></div>
		<div class="row">
			<div class="wrap_table">
				<div align="center">
					<table>
						<caption></caption>
						<thead class="mdl-shadow--2dp">
							<tr>
								<th style="width: 10%">교수 ID</th>
								<th style="width: 10%">학과 번호</th>
								<th style="width: 15%">과목 코드</th>
								<th style="width: 15%">전공 옵션</th>
								<th style="width: 15%">담당 교수</th>
								<th style="width: 25%">과목 이름</th>
								<th style="width: 20%">신청</th>
							</tr>
						</thead>
						<tbody id="subjectList">
							<c:forEach var="supplementLectureList"
								items="${supplementLectureList }">
								<tr id="supplementLectureTr-${supplementLectureList.subjectNo}">
									<td style="width: 10%" id="id-' + professorId + '"><label>${supplementLectureList.professorId}</label></td>
									<td style="width: 10%" id="code-' + majorCode + '"><label>${supplementLectureList.majorCode}</label></td>
									<td style="width: 15%" id="subjectNo-' + subjectNo + '"><label>${supplementLectureList.subjectNo}</label></td>
									<td style="width: 15%" id="majorOption' + majorOption + '"><label>${supplementLectureList.majorOption}</label></td>
									<td style="width: 15%" id="professorName-' + professorName + '"><label>${supplementLectureList.professorName}</label></td>
									<td style="width: 25%" id="subjectName-' + subjectName + '"><label>${supplementLectureList.subjectName}</label></td>
									<c:choose>
										<c:when
											test="${supplementLectureList.makeupLessonRegister eq 'y'}">
											<td style="width: 20%" id="cancleButton">
												<button
													id="lectureCancle-${supplementLectureList.subjectNo}"
													class="mdl-button mdl-js-button mdl-button--accent"
													data-toggle="modal" data-target=".bs-example-modal-lg">
													<i class="glyphicon glyphicon-remove-circle">취소</i>
												</button>
											</td>
										</c:when>
										<c:otherwise>

											<td style="width: 15%"
												id="applicationButton-${supplementLectureList.subjectNo}">
												<button
													id="lectureApplication-${supplementLectureList.subjectNo}"
													class="mdl-button mdl-js-button mdl-button--primary"
													data-toggle="modal" data-target=".bs-example-modal-lg">
													<i class="glyphicon glyphicon-ok-circle">신청</i>
												</button>
											</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot class="mdl-shadow--2dp">
							<tr>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<div class="row" style="height: 10px"></div>
		<div class="row">
			<form action="">
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-1">
						<label>Search :</label>
					</div>
					<div class="col-sm-1">
						<input id="searchdatil-id" type="radio" name="searchdatil"
							value="id" />ID
					</div>
					<div class="col-sm-1">
						<input id="searchdatil-name" type="radio" name="searchdatil"
							value="name" />NAME
					</div>
					<div class="col-sm-3">
						<input id="searchdatil-subjectNo" type="radio" name="searchdatil"
							value="subjectNo" />SUBJECTNO
					</div>
					<div class="col-sm-3">
						<input id="searchText" type="text" class="form-control" />
					</div>
					<div class="col-sm-2">
						<button value="" type="submit" class="mdl-button mdl-js-button"
							id="search-button-type">
							<i class="material-icons">search</i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<hr />
		<div class="row" style="height: 30px"></div>
		<div class="row">
			<h4>&nbsp;&nbsp;&nbsp;최근 신청한 강의</h4>
			<div class="wrap_table">
				<div align="center">
					<table>
						<caption></caption>
						<thead class="mdl-shadow--2dp">
							<tr>
								<th style="width: 10%">교수 ID</th>
								<th style="width: 10%">학과 번호</th>
								<th style="width: 15%">과목 코드</th>
								<th style="width: 15%">전공 옵션</th>
								<th style="width: 15%">담당 교수</th>
								<th style="width: 25%">과목 이름</th>
								<th style="width: 20%">신청</th>
							</tr>
						</thead>
						<tbody id="subjectListaddList"></tbody>
						<tfoot class="mdl-shadow--2dp">
							<tr>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<hr />
		<h4>보강 신청 메세지 보내기</h4>
		<div class="row" style="margin-bottom: 15px;">
			<div class="col-sm-12">
				<div class="btn-group">
					<a href="adminrecmessagebox" class="mdl-button mdl-js-button mdl-button--raised">받은쪽지</a> <a
						href="adminsendmessagebox" class="mdl-button mdl-js-button mdl-button--raised">보낸쪽지</a> <a
						href="adminmessageform" class="mdl-button mdl-js-button mdl-button--raised">쪽지쓰기</a>
				</div>
			</div>
		</div>
		<div class="row">
			<form method="post" action="sendmessage" id="message-form"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered mdl-shadow--2dp">
							<colgroup>
								<col width="10%">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<td>수신대상</td>
									<td><label class="radio-inline"><input
											type="radio" name="menu" value="stu" checked>
											학생&nbsp;</label> <label class="radio-inline"><input
											type="radio" name="menu" value="pro"> 교수</label></td>
								</tr>
								<tr class="form-inline">
									<td>받는사람</td>
									<td><span id="receiver-box"></span>
										<button type="button" class="btn btn-xs btn-default mdl-shadow--2dp"
											data-toggle="modal" data-target="#searchModal">사용자
											검색</button>

										<div id="searchModal" class="modal fade" role="dialog">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header text-center">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<div class="form-inline input-group">
															<select class="form-control" name="option" id="option">
																<option value="name">이름</option>
																<option value="division">학과</option>
																<option value="subject">과목</option>
															</select> <span class="input-group-addon"><i
																class="glyphicon glyphicon-search"></i></span> <input
																type="text" class="form-control" id="search-word">
															<div class="input-group-btn">
																<button type="button" class="btn btn-success"
																	id="search-list">검색</button>
															</div>
														</div>
													</div>
													<div class="modal-body" id="search-result">
														<div style="height: 400px; overflow: auto;">
															<table class="table table-bordered">
																<colgroup>
																	<col width="20%">
																	<col width="20%">
																	<col width="30%">
																	<col width="30%">
																</colgroup>
																<thead>

																</thead>
																<tbody>

																</tbody>
															</table>
														</div>
													</div>
													<div class="modal-footer text-right">
														<button class="btn btn-info" id="add-list">추가</button>
														<button type="button" class="btn btn-default"
															data-dismiss="modal" id="close-modal">닫기</button>
													</div>
												</div>
											</div>
										</div></td>
								</tr>
								<tr>
									<td>제목</td>
									<td><input type="text" class="form-control" name="title">
									</td>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea rows="10" class="form-control"
											name="contents"></textarea></td>
								</tr>
								<tr>
									<td>첨부파일</td>
									<td><input type="file" class="form-control" name="file">
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 text-center">
						<button type="submit" class="mdl-button mdl-js-button mdl-button--raised" id="send-button" style="width: 100px">발송</button>
						<button type="button" class="mdl-button mdl-js-button mdl-button--raised" style="width: 100px"
							onclick="history.back()">취소</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<footer>
		<div class="row" style="height: 80px"></div>	
	</footer>
</body>
</html>