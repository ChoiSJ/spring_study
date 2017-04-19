<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div id="wrapper">
        <div id="sidebar-wrapper">
            <aside id="sidebar">
                <ul id="sidemenu" class="sidebar-nav" style="background-color: #4296dc;">
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" data-target="#submenu-2">
                            <span class="sidebar-icon"></span><span class="sidebar-title">교수 정보</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-2" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="#"><i class="fa fa-caret-right"></i>정보 조회</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>정보 수정</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-3">
                            <span class="sidebar-icon"></span><span class="sidebar-title">강의관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-3" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="/jhta/prof/subinfo"><i class="fa fa-caret-right"></i>강의 조회</a></li>
                            <li><a href="/jhta/prof/addenrollform"><i class="fa fa-caret-right"></i>강의 등록</a></li>
                            <li><a href="/jhta/prof/syllinfo"><i class="fa fa-caret-right"></i>강의계획서 조회</a></li>
                            <li><a href="/jhta/prof/syllform"><i class="fa fa-caret-right"></i>강의계획서 등록</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-4">
                            <span class="sidebar-icon"></span><span class="sidebar-title">성적 관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-4" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="#"><i class="fa fa-caret-right"></i>성적 입력</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>성적 정정</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>이의신청 관리</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-5">
                            <span class="sidebar-icon"></span><span class="sidebar-title">과제 관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-5" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="#"><i class="fa fa-caret-right"></i>과제 등록</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>과제 현황 및 평가</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-6">
                            <span class="sidebar-icon"></span><span class="sidebar-title">평가 관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-6" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="#"><i class="fa fa-caret-right"></i>설문 등록</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>강의 평가 등록</a></li>
                            <li><a href="#"><i class="fa fa-caret-right"></i>강의 평가 조회</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-7">
                            <span class="sidebar-icon"></span><span class="sidebar-title">게시판</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-7" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="profnoticeboard"><i class="fa fa-caret-right"></i>강의 공지사항</a></li>
                            <li><a href="profqnaboard"><i class="fa fa-caret-right"></i>강의 Q/A</a></li>
                            <li><a href="profdeptboard"><i class="fa fa-caret-right"></i>학과 게시판</a></li>
                        </ul>
                    </li>
                   
                </ul>
            </aside>            
        </div>
    </div>
