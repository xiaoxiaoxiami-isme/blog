<#include "include/macros.ftl">
<@header title="友情链接 | ${config.siteName}"
    keywords="${config.siteName},友情链接交换"
    description="${config.siteName}，一个程序员的个人原创博客，友情链接交换"
    canonical="/links">
</@header>

<div class="container custome-container">
    <nav class="breadcrumb">
        <a class="crumbs" title="返回首页" href="${config.siteUrl}" data-toggle="tooltip" data-placement="bottom"><i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>友情链接
    </nav>
    <div class="row">
        <@blogHeader title="友情链接"></@blogHeader>
        <div class="col-sm-12 blog-main">
            <div class="blog-body expansion">
                <#--<h5 class="legend-title">简单的要求<small> - 简单点，说话的方式简单点</small></h5>-->
                <h4 class="bottom-line"><i class="fa fa-coffee fa-fw"></i><strong>简单的要求</strong><small> - 简单点，说话的方式简单点</small></h4>
                <div class="link-info">
                    <ul class="list-unstyled">
                        <li>本站定位：个人技术类博客</li>
                        <li>本站作用：写博客、记日志、闲聊扯淡鼓捣技术</li>
                        <li>本站 <em>优先</em> 选择<kbd>同类原创、内容相近</kbd>的博客或网站，您的站点内容可以为<kbd>技术类</kbd>、<kbd>IT科技</kbd>、<kbd>互联网</kbd>和<kbd>生活</kbd></li>
                        <li>特别提醒：<abbr title="禁止友链的网站">任何包含违反国家法律法规内容的网站、盈利类（赌博）网站，还有相亲类、卖表类的网站、垃圾站统统不做！！！</abbr></li>
                    </ul>
                </div>
            </div>
        </div>
   
        <#if linkList?exists && (linkList?size > 0)>
        <div class="col-sm-12 zhyd-container">
            <div class="zhyd-box zhyd-os">
                <div class="category">
                    <div><i class="fa fa-link fa-fw fa-2x"></i>内页友链 <small>(排名不分前后)</small></div>
                </div>
                <div class="col-sm-12 col-md-12" style="margin: 0 auto;float: initial">
                    <section class="links none-bg">
                        <ul class="list-unstyled list-inline">
                            <#list linkList as item>
                                <li>
                                    <a href="${item.linkUrl}" target="_blank" title="${item.linkDescription}" data-toggle="tooltip" data-placement="bottom">
                                        <img src="${item.linkImage}" alt="${item.linkName}" onerror="this.src='${config.siteUrl}/img/user.png'">${item.linkName}
                                    </a>
                                </li>
                            </#list>
                        </ul>
                    </section>
                </div>
            </div>
        </div>
        </#if>
      
    </div>
</div>


<@footer>
    <script type="text/javascript">
        eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$(k(){$("#n").g({0:"\\10\\R\\N\\M\\z",y:{l:"2 2-x",w:"2 2-v",u:"2 2-t"},s:{r:{3:{9:{0:"\\c\\d\\J\\q\\1\\e\\7\\f"}}},h:{3:{9:{0:"\\c\\d\\5\\4\\1\\e\\7\\f"},o:{0:"\\1\\8\\6\\j\\5\\4"}}},A:{3:{B:{0:"\\1\\8\\6\\j\\C\\D\\5\\4"}}},E:{3:{9:{0:"\\c\\d\\F\\G\\1\\e\\7\\f"}}},H:{3:{o:{0:"\\I\\p\\5\\4\\1\\8\\6"}}}}});$(".K").L(k(){i a=$("#n");a.g("O");P(Q.l(a)){i b=a.S("T");$.U({V:"W",h:b,X:a.Y(),Z:$.m.11,12:$.m.13})}})});',62,66,'message|u4e0d|fa|validators|u5740|u5730|u6cd5|u4e3a|u5408|notEmpty|||u7ad9|u70b9|u80fd|u7a7a|bootstrapValidator|url|var|u7684|function|valid|tool|autoLinkForm|uri|u6807|u79f0|name|fields|refresh|validating|remove|invalid|check|feedbackIcons|u6548|email|emailAddress|u90ae|u7bb1|description|u63cf|u8ff0|favicon|u56fe|u540d|autoLink|click|u65e0|u503c|validate|if|_form|u5165|attr|action|ajax|type|POST|data|serialize|success|u8f93|ajaxSuccess|error|ajaxError'.split('|'),0,{}))
    </script>
    <script src="https://v1.hitokoto.cn/?encode=js&c=d&select=%23hitokoto" defer></script>
</@footer>
