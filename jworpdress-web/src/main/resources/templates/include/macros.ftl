<#-- 公共顶部 -->
<#macro header title="HARRIES BLOG™" keywords="默认文字" description="默认文字" canonical="">
<#include "/common/annotation.ftl">
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>${seoVO.title}</title>
    <meta name="keywords" content="${seoVO.keywords}"/>
    <meta name="description" content="${seoVO.description}" id="meta_description">
    <link rel="canonical" href="${config.siteUrl}" />
    <#include "/layout/quote.ftl">
    <#--黑白界面
    <style>
        html {
            filter: grayscale(100%);
            -webkit-filter: grayscale(100%);
            -moz-filter: grayscale(100%);
            -ms-filter: grayscale(100%);
            -o-filter: grayscale(100%);
            filter: url("data:image/svg+xml;utf8,<svg xmlns="\'http://www.w3.org/2000/svg\'"><filter id="\'grayscale\'"><feColorMatrix type="\'matrix\'" values="\'0.3333" 0.3333="" 0="" 1="" 0\'=""></fecolormatrix></filter></svg>#grayscale");filter:progid:DXImageTransform.Microsoft.BasicImage(grayscale=1);-webkit-filter:grayscale(1);}
    </style>-->
    <#nested>
</head>
<body>
    <#include "/layout/header.ftl"/>
</#macro>

<#-- 公共底部 -->
<#macro footer>
    <#include "/layout/footer.ftl"/>

    <#nested>

    </body>
</html>
</#macro>

<#-- 分页组件 -->
<#macro pageBar>
    <#if page?exists && (page.pages > 1)>
    <nav>
        <ul class="pager page-btn" data-url="${config.siteUrl}/${url?if_exists}" data-search="">
           <#-- 是否上一页--> 
            <#if page.hasPreviousPage>
             <li><a class="pointer" data-page="1">首页</i></a></li>
            <li><a class="pointer" data-page="${page.prePage}">上一页</i></a></li>
            </#if>

				<#--处理开头部分逻辑 -->
			 <#if (page.navigateFirstPage = 2)>
			        		<li><a class="pointer" data-page="1">1</a></li>
			        <#elseif (page.navigateFirstPage > 2)>
			        		<li><a class="pointer" data-page="1">1</a></li>
			        		<li>...</li>
			  </#if>      
			  <#-- 中间显示页数--> 
			  <#list page.navigateFirstPage..page.navigateLastPage as item>
			  			<li><a ${(page.pageNum == item)?string('class="pointer active"','class="pointer" data-page="${item?c}"')}>${item?c}</a></li>
			  </#list>
               <#--处理结果部分显示的逻辑--> 
				<#if (page.navigateLastPage = page.pages-1)>
			        		<li><a class="pointer" data-page="${page.pages}">${page.pages}</a></li>
			        <#elseif (page.navigateLastPage < page.pages-1)>
			        		<li>...</li>
			        		<li><a class="pointer" data-page="${page.pages}">${page.pages}</a></li>
			  </#if> 
 			 <#-- 是否下一页--> 
			  <#if page.hasNextPage>
			            <li><a class="pointer active" data-page="${page.nextPage}">下一页</i></a></li>
			              <li><a class="pointer" data-page="${page.pages}">尾页</i></a></li>
           		 </#if>
               <li> 共 ${page.pages} 页 </li>
        </ul>
    </nav>
    </#if>
</#macro>


<#-- blog-header -->
<#macro blogHeader title="Header">
    <div class="col-sm-12 blog-main">
        <div class="blog-header">
            <h1 class="blog-title">${title}</h1>
            <p class="blog-description" id="hitokoto"></p>
            <div class="info">
                <a href="javascript:void(0);" target="_blank" title="点击QQ联系我"onclick="window.open('tencent://message/?uin=843977358&amp;Site=www.${config.domain}&amp;Menu=yes')" rel="external nofollow"><i class="fa fa fa-qq fa-fw"></i>QQ联系</a>
                |
                <a href="mailto:yadong.zhang0415@gmail.com" target="_blank" title="点击给我发邮件" rel="external nofollow"><i class="fa fa fa-envelope fa-fw"></i>邮箱联系</a>
                |
                <a href="http://weibo.com/211230415" target="_blank" title="点击查看我的微博" rel="external nofollow"><i class="fa fa fa-weibo fa-fw"></i>@七彩狼丿</a>
            </div>
        </div>
    </div>
</#macro>