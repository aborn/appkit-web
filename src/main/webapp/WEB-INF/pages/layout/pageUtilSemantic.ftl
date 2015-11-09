<#macro pageNavigation pageModel url searchParams>

<#--
    TODO:第一页不需要传递参数pageno，后台处理的时候pageno默认为1
    输出分页导航
        1.引用的页面需要能获取到  pageModel:PageModel 对象
            @see com.dianping.avatar.dao.PageModel
        2.分页导航中始终需要输出第一页和最后一页
    @param pageModel.pageCount : 总的页数
    @param pageModel.page ： 当前页
    @param params : 传递参数
    @author mingxing.ma
    @create 2010-10-29
-->
    <#if pageModel?exists && (pageModel.pageCount > 1)>
        <#assign curPage = pageModel.page>
        <#assign pageCount = pageModel.pageCount>

    <#--
        开始页 : 求最大值(当前页和2的差值 , 1)
    -->
        <#if ((curPage - 4) > 1)>
            <#assign startPage = (curPage - 4)>
        <#else>
            <#assign startPage = 1>
        </#if>

    <#--
        结束页 : 求最小值(开始页+8, 总页数)
    -->
        <#if ((startPage + 6) < pageCount)>
            <#assign endPage = (startPage + 6)>
        <#else>
            <#assign endPage = pageCount>
        </#if>

    <div class="ui pagination menu">
    <#--如果当前页大于第一页，输出上一页导航-->
        <#if (curPage > 1) >
            <a class="item" href="${url}?${searchParams}&pageno=${curPage - 1}"><span title="上一页">‹‹</span></a>
        <#else>
            <a class="disabled item"><span title="上一页">‹‹</span></a>
        </#if>

    <#--开始输出页码导航-->
    <#--
        如果开始页大于1 (表示当前页和2的差值大于1)
            先输出"第一页的link"和"..."
        否则跳过
            然后由遍历的过程输出第一页的链接
    -->
        <#if (startPage > 1)>
            <a class="item" href="${url}?${searchParams}&pageno=1">1<span  class="sr-only">(current)</span></a>
            <div class="disabled item">
                ...
            </div>
        </#if>

    <#--
        遍历输出开始页到结束页的链接
            如果是当前页，页码没有链接并且有自己的样式
    -->
        <#if (startPage <= endPage)>
            <#list startPage..endPage as page>
                <#if curPage == page>
                    <a class="active item">${page}</a>
                <#else>
                    <a class="item" href="${url}?${searchParams}&pageno=${page}">${page}</a>
                </#if>
            </#list>
        </#if>

    <#--
        如果endPage < pageCount 	(表示结束页是startPage + 8，否则endPage = pageCount)
            1.先判断是否小于最后一页的前一页,如果是先输出"..."，否则跳过
            2.单独输出最后一页
        否则跳过
            实质上在上面的遍历的过程中已经输出了最后一页的链接
    -->
        <#if (endPage < pageCount)>
            <#if (endPage < pageCount - 1)>
                <div class="disabled item">
                    ...
                </div>
            </#if>
            <a class="item" href="${url}?${searchParams}&pageno=${pageCount}">${pageCount}</a>
        </#if>

    <#--如果当前页小于总页数，输出下一页导航-->
        <#if (curPage < pageCount)>
            <a class="item" href="${url}?${searchParams}&pageno=${curPage + 1}" title="下一页">››</a>
        <#else>
            <li class="disabled">
                <a><span title="下一页">››</span></a>
            </li>
        </#if>
    <#--结束输出页码导航-->
    </div>
    </#if>
</#macro>

<#--
	定义其他公用ftl方法或者宏放在freemarkerUtil中.在此引入.方便各处调用及管理.
-->

<#function cutString str,len>
    <#if str?length &gt; len>
        <#return str?substring(0,len?int) + "...">
    <#else>
        <#return str>
    </#if>
</#function>