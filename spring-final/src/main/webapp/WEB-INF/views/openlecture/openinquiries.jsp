<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 설정 경로 지정  href에 부트스트랩이 저장되어있는 경로를 적는다.-->
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<style>
    .wrap_table {
        padding: 30px 0;
        position: relative;
        width: 1180px;
    }

    .wrap_table>div {
        overflow: auto;
        height: 300px;
    }

    .wrap_table table {
        width: 1165px;
    }

    .wrap_table table caption {
        height: 0;
        overflow: hidden;
    }

    .wrap_table table thead,
    .wrap_table table tfoot {
        position: absolute;
        display: table;
        width: 1165px;
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

<script type="text/javascript">
    $(function() {


        //disable 하는 함수 바로 실행
        $('button[id^=openlecture]').each(function(index, item) {
            var register = $(item).attr('value');
            if (register == 'n') {
                $(this).addClass('disabled', 'disabled');
                
            }
        });


        //상세 정보 조회
        $("#search-button").on("click", function(event) {

            event.preventDefault();

            $("#professorlist tr").hide();

            var Search = $("#fixed-header-drawer-exp").val();

            $("td:contains(" + Search + ")").parents("tr").show();

            if ($("td:contains(" + Search + ")").length == 0) {
                alert("요청하신 정보를 찾지 못하였습니다.");

                $("#professorlist tr").show();
            }

        });


        //삭제 ajax
        $("#subjectdelete").on("click", function() {


            var $button = $(this).attr("id").replace("openlecture-", "");
            console.log($button)
            var text = $("#professorlist :checked").val().split("-")
            var deleteNo = text[0];

            var deleteId = text[1];

            $("#subjectdelete").attr("value", deleteNo);


            var register = text[2];


            if (register == 'y') {

                $.ajax({
                    type: "DELETE",
                    url: "deletesubject/" + deleteNo + "/" + deleteId,
                    dataType: "json",
                    success: function(data) {
					
                    	window.location.href="http://localhost/jhta/admin/openLectureTableAll.do";
                    	
                    }
                });

            } else {
                alert("강의평가가 등록되어있는 강의가 아닙니다.")
            }

        });




        //모달 강의 평가 
        $("button[id^='openlecture']").on("click", function(event) {

            var SubjectNo = $(this).attr('id').replace('openlecture-', '');


            $.ajax({
                type: "GET",
                url: "subjectNo/" + SubjectNo,
                dataType: "json",
                success: function(data) {

                    var $div = $("#modaldata").empty();
                    if (data.length) {
                        var html = '<div class="container">';
                        html += '<h3>강의 계획서</h3>';
                        html += '<table style="width: 870px;">';
                        html += '<tr>';
                        html += '<td>';
                        html += '<p>&nbsp;◎ 본조사는 중앙 HTA 대학교 재학생을 대상으로 한 교육만족도 증진을 위한 만족도 조사로 익명으로 실시되오니 솔직하고 정확하게 작성 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;해 주시기 바랍니다.&nbsp; </p>';
                        html += '<p>&nbsp;◎ 여러분이 응답하여 주신 각각의 자료는 보다 나은 교육서비스 체제 구축을 위한 발전방안을 마련하는 기초자료로 적극 반영될 것입니다.</p>';
                        html += '</td>';
                        html += '</tr>';
                        html += '</table>';
                        html += '<table class="table table-default" style="width: 870px;">';
                        html += '<tr>';
                        html += '<td colspan="7">';
                        html += '<p>&nbsp;&nbsp;■ 다음은 교육과정(전공, 교양)에 대한 질문입니다. 해당란에 체크표 해주십시오.&nbsp;&nbsp;</p>';
                        html += '</td>';
                        html += '</tr>';
                        html += '<tr>';
                        html += '<td align="center" style="size: 1">구분</td>';
                        html += '<td style="width:40%" align="center" style="size: 1">조사 항목</td>';
                        html += '<td style="width:10%" align="center">';
                        html += '<p align="center" style="size: 1">매우그렇다</p>';
                        html += '</td>';
                        html += '<td style="width:10%" align="center" style="size: 2">';
                        html += '<p align="center" style="size: 1">대체로 그렇다</p>';
                        html += '</td>';
                        html += '<td style="width:10%" align="center" style="size: 2">';
                        html += '<p align="center" style="size: 1">그저 그렇다</p>';
                        html += '</td>';
                        html += '<td style="width:10%" align="center" style="size: 2">';
                        html += '<p align="center" style="size: 1">대체로 아니다</p>';
                        html += '</td>';
                        html += '<td style="width:10%" align="center" style="size: 2">';
                        html += '<p align="center" style="size: 1">전혀아니다</p>';
                        html += '</td>';
                        html += '</tr>';

                        for (i = 0; i < data.length; i++) {

                            html += '<tr id="">';
                            html += '<td style="width:10%" align="center" style="size: 1">' + (i + 1) + '</td>';
                            html += '<td style="width:40%" align="center" style="size: 1">' + data[i].contents + '</td>';
                            html += '<td style="width:10%" align="center" style="size: 1">';
                            html += '<input type="radio" checked="checked" name="appraise" style="size: 1"/>';
                            html += '</td>';
                            html += '<td style="width:10%" align="center" style="size: 1">';
                            html += '<input type="radio" name="appraise" style="size: 1"/>';
                            html += '</td>';
                            html += '<td style="width:10%" align="center" style="size: 1">';
                            html += '<input type="radio" name="appraise" style="size: 1"/>';
                            html += '</td>';
                            html += '<td style="width:10%" align="center" style="size: 1">';
                            html += '<input type="radio" name="appraise" style="size: 1"/>';
                            html += '</td>';
                            html += '<td style="width:10%" align="center" style="size: 1">';
                            html += '<input type="radio" name="appraise" style="size: 1"/>';
                            html += '</td>';
                            html += '</tr>';
                        }
                        html += '</table>';
                        html += '</div>';


                        $div.append(html);
                    } else {

                    }



                }
            })
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
</head>
<body>
	<%@ include file="/WEB-INF/views/navi/adminnavi.jsp"%>
	<%@ include file="/WEB-INF/views/navi/openlecture.jsp"%>
	<div class="container" style="margin-left: 250px; padding-top: 25px;">
	<div class="row text-right">
			홈 > 강의 평가 관리 > 강의평가 조회/삭제
		</div>
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="modal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content" id="modaldata"></div>
			</div>
		</div>
		<h5><span class="glyphicon glyphicon-th-list"></span>강의 평가 조회 /삭제</h5>
		<hr style="border:solid 0.5px #2C7BB5;">
		<div class="row">
			<h5>&nbsp;&nbsp;과목 조회</h5>
			<div class="row">
				<form action="">
					<div class="mdl-layout__header-row">
						<div id="search-option" class="mdl-layout-spacer"></div>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right">
							<label class="mdl-button mdl-js-button mdl-button--icon"
								for="fixed-header-drawer-exp"><i class="material-icons">search</i>
							</label>
							<div id="search-text" class="mdl-textfield__expandable-holder">
								<input class="mdl-textfield__input" type="text"
									id="fixed-header-drawer-exp" placeholder="검색어 입력">
							</div>
						</div>
						<button id="search-button" hidden="hidden"></button>
					</div>
				</form>
			</div>
		<div class="wrap_table">
			<div align="center">
				<table class="mdl-shadow--2dp">
					<caption></caption>
					<thead class="mdl-shadow--2dp">
						<tr>
							<th style="width: 10%"></th>
							<th style="width: 15%">과목 코드</th>
							<th style="width: 15%">과목 번호</th>
							<th style="width: 30%">과목 이름</th>
							<th style="width: 15%">전공 코드</th>
							<th style="width: 15%">미리 보기</th>
						</tr>
					</thead>
					<tbody id="professorlist">
						<c:forEach var="professorListTable" items="${professorListTable }">
							<tr>
								<td style="width: 10%"><input type="radio"
									name="subjectradio"
									value="${professorListTable.subjectNo }-${professorListTable.subjectProfeesorId }-${professorListTable.register}" /></td>
								<td style="width: 15%"><label>${professorListTable.subjectCode }</label></td>
								<td style="width: 15%"><label>${professorListTable.subjectNo }</label></td>
								<td style="width: 30%"><label>${professorListTable.subjectName }</label></td>
								<td style="width: 15%"><label>${professorListTable.subjectPassd }</label></td>
								<td style="width: 15%">
									<button value="${professorListTable.register }"
										id="openlecture-${professorListTable.subjectNo }"
										type='button' class='btn btn-default btn-xs'
										data-toggle='modal' data-target='.bs-example-modal-lg'>
										<i class='glyphicon glyphicon-list-alt'></i>
									</button>
								</td>
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
		<div class="row">
			<button id="subjectdelete" type="submit"
				class='mdl-button mdj-js-button mdl-button-fab mdl-button-mini-fab pull-right'
				style='color: black' value="">
				<i class='material-icons md-48'>delete_forever</i>
			</button>
		</div>
		<hr />
		<h5>메세지 보내기</h5>
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
																<button type="button" class="btn btn-default"
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