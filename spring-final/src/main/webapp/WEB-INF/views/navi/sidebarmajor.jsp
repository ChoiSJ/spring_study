<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div id="wrapper">
        <div id="sidebar-wrapper">
            <aside id="sidebar">
                <ul id="sidemenu" class="sidebar-nav" style="background-color: #4296dc;">
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" data-target="#submenu-2">
                            <span class="sidebar-icon"></span><span class="sidebar-title">학기관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-2" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="semester"><i class="fa fa-caret-right"></i>학기목록</a></li>
                            <li><a href="addSemester"><i class="fa fa-caret-right"></i>학기등록</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="accordion-toggle collapsed toggle-switch" data-toggle="collapse" href="#submenu-3">
                            <span class="sidebar-icon"></span><span class="sidebar-title">과목관리</span>
                            <b class="caret"></b>
                        </a>
                        <ul id="submenu-3" class="panel-collapse collapse panel-switch" role="menu">
                            <li><a href="subjectmain"><i class="fa fa-caret-right"></i>과목검색</a></li>
                            <li><a href="addsubject"><i class="fa fa-caret-right"></i>과목등록</a></li>
                        </ul>
                    </li>
                </ul>
            </aside>            
        </div>
    </div>
