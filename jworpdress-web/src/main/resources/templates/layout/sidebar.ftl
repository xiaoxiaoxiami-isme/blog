<div class="col-sm-3 blog-sidebar">
    <#if articleDetail?exists>
        <div class="sidebar-module">
            <h5 class="sidebar-title"><i class="fa fa-hand-peace-o icon"></i><strong>说给你听</strong></h5>
            <div class="div-quote">
                <i class="fa fa-quote-left fa-fw"></i><p id="hitokoto" style="margin-left: 15px;"></p>
            </div>
        </div>
    <#else>
        <div class="sidebar-module" style="position: relative;">
            <a href='https://gitee.com/jxuasea/JWordpress' target="_blank" rel="external nofollow"><img src='https://gitee.com/yadong.zhang/DBlog/widgets/widget_1.svg?color=07b83f' alt='Fork me on Gitee' style="position: absolute;right: 0;"/></a>
            <h5 class="sidebar-title"><i class="fa fa-home icon"></i><strong>关于我</strong></h5>
            <div class="widget">
                <div id="feed_widget">
                    <div class="feed-about">
                        <div class="about-main">
                            <div class="about-img"><a href="${config.siteUrl}/img/qrcode_gzh.jpg" class="showImage" title="微信公众号"><img src="${config.siteUrl}/img/javazaji.png" alt="微信公众号"></a></div>
                            <div class="about-name">Harries</div>
                        </div>
                        <div class="clear"></div>
                        <!-- 方案一：图标展示 -->
                        <ul class="widget-icon">
                            <li class="weixin auto-shake" data-container="body"
                                data-toggle="popover" data-trigger="hover" data-placement="bottom" data-html="true" data-content="<img src='${config.siteUrl}/img/qrcode_gzh.jpg' style='width: 130px;' alt='QR Code'>">
                                <a class="tag-icon" title="微信" rel="external nofollow"><i class="fa fa-weixin"></i></a>
                            </li>
                            <li class="tqq auto-shake">
                                <a class="tag-icon" href="#" title="点击QQ联系我" target="blank" rel="external nofollow"><i class="fa fa-qq"></i></a>
                            </li>
                            <li class="tsina auto-shake">
                                <a class="tag-icon" href="#" title="点击查看我的微博" target="_blank" rel="external nofollow"><i class="fa fa-weibo"></i></a>
                            </li>
                            <li class="github auto-shake">
                                <a class="tag-icon" href="https://gitee.com/jxuasea/JWordpress" title="点击查看我的github" target="_blank" rel="external nofollow"><i class="fa fa-github"></i></a>
                            </li>
                        </ul>
                       
                    </div>
                </div>
            </div>
        </div>
    </#if>
    <div class="sidebar-module article-module hide" style="top: 0;">
        <h5 class="sidebar-title"><i class="fa fa-book icon"></i><strong>本文目录</strong> <i class="fa fa-close pull-right close-article-menu hide pointer"></i></h5>
        <div id="article-menu">
            <ul class="list-unstyled">
            </ul>
        </div>
    </div>
    <div class="sidebar-module">
        <h5 class="sidebar-title"><i class="fa fa-tags icon"></i><strong>文章标签</strong></h5>
        <ul class="list-unstyled list-inline">
            <@customTag method="tagsList" pageSize="10">
                <#if tagsList?exists && (tagsList?size > 0)>
                    <#list tagsList as item>
                        <li class="tag-li">
                            <a class="btn btn-default btn-xs" href="${config.siteUrl}/tag/${item.termId}" title="${item.name?if_exists}" data-toggle="tooltip" data-placement="bottom">
                                ${item.name?if_exists}
                            </a>
                        </li>
                    </#list>
                </#if>
            </@customTag>
        </ul>
    </div>
    <@customTag method="recentComments" pageSize="10">
        <#if recentComments?? && recentComments?size gt 0>
            <div class="sidebar-module">
                <h5 class="sidebar-title"><i class="fa fa-comments icon"></i><strong>近期评论</strong></h5>
                <ul class="list-unstyled list-inline comments">
                <#list recentComments as item>
                    <li>
                        <a href="${item.commentAuthorUrl}#comment-${item.commentId?c}" title="${item.commentContent?if_exists}" rel="external nofollow" data-toggle="tooltip" data-placement="bottom">
                            <img alt="${item.commentAuthor?if_exists}" src="${item.avatar?if_exists}" class="avatar auto-shake" height="64" width="64" onerror="this.src='${config.siteUrl}/img/user.png'" />
                            <span class="comment-author">${item.commentAuthor?if_exists}</span> ${item.commentContent?if_exists}
                        </a>
                    </li>
                </#list>
                </ul>
            </div>
        </#if>
    </@customTag>
    <div class="sidebar-module">
        <ul class="nav nav-tabs sidebar-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><i class="fa fa-list"></i>近期文章</a></li>
            <li role="presentation"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-thumbs-o-up"></i>站长推荐</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab"><i class="fa fa-hand-peace-o"></i>随机文章</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="profile">
                <ol class="list-unstyled">
                    <@articleTag method="recentList" pageSize="10">
                        <#if recentList?exists && (recentList?size > 0)>
                            <#list recentList as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/archives/${item.id?c}" title="${item.postTitle}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.postTitle}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
            <div role="tabpanel" class="tab-pane" id="home">
                <ol class="list-unstyled">
                    <@articleTag method="recommendedList" pageSize="10">
                        <#if recommendedList?exists && (recommendedList?size > 0)>
                            <#list recommendedList as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/archives/${item.id?c}" title="${item.postTitle}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.postTitle}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
            <div role="tabpanel" class="tab-pane" id="messages">
                <ol class="list-unstyled">
                    <@articleTag method="randomList" pageSize="10">
                        <#if randomList?exists && (randomList?size > 0)>
                            <#list randomList as item>
                                <li>
                                    <span class="li-icon li-icon-${item_index + 1}">${item_index + 1}</span>
                                    <a href="${config.siteUrl}/archives/${item.id?c}" title="${item.postTitle}" data-toggle="tooltip" data-placement="bottom">
                                        ${item.postTitle}
                                    </a>
                                </li>
                            </#list>
                        </#if>
                    </@articleTag>
                </ol>
            </div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="sidebar-module">
        <h5 class="sidebar-title"><i class="fa fa-info icon"></i><strong>网站信息</strong></h5>
        <ul class="ul-default">
            <@customTag method="siteInfo">
                <li> <i class="fa fa-file fa-fw"></i>  文章总数：${siteInfo.postCount!(0)} 篇</li>
                <li> <i class="fa fa-tags fa-fw"></i> 标签总数：${siteInfo.tagCount!(0)} 个</li>
                <li> <i class="fa fa-folder-open fa-fw"></i> 分类总数：${siteInfo.categoryCount!(0)} 个</li>
                <li> <i class="fa fa-comments fa-fw"></i> 留言数量：${siteInfo.commmentCount!(0)} 条</li>
                <li> <i class="fa fa-users fa-fw"></i> 在线人数：<span class="online">11</span>人</li>
                <li> <i class="fa fa-calendar fa-fw"></i> 运行天数：${siteInfo.buildSiteDate!(0)}天</li>
                <li> <i class="fa fa-pencil-square fa-fw"></i> 最后更新：${siteInfo.recordeTime}</li>
            </@customTag>
        </ul>
    </div>
</div>