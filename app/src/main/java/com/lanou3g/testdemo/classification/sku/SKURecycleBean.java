package com.lanou3g.testdemo.classification.sku;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by 程洪运 on 16/10/14.
 */
public class SKURecycleBean {
    /**
     * code : 200
     * data : {"items":[{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/8k579o621.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/8k579o621.jpg?imageView2/2/w/720/q/85/format/webp","description":"USB接口的暖手宝，马卡龙色系，随时随地就能保暖~","favorites_count":572,"id":1043991,"liked":false,"likes_count":572,"name":"幸运石马卡龙暖手宝","price":"98.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/cbgfilupt.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/cbgfilupt.jpg?imageView2/2/w/720/q/85/format/webp","description":"很文艺的一款单间包，芥末黄色让你在人群里闪闪动人，陪你逛街、陪你通勤，陪你的小确幸生活里的每一天。","favorites_count":342,"id":1044441,"liked":false,"likes_count":342,"name":"YIZI 手提单肩帆布包","price":"35.20","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/7uxds8i59.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/7uxds8i59.jpg?imageView2/2/w/720/q/85/format/webp","description":"奶瓶外形设计，小巧玲珑，轻轻松松捧在手心。糖果色设计，可以用USB充电加热，很安全的防爆设计。造型实在太可爱了，出门带着上它随时随地暖暖手，过个暖冬就靠它了~","favorites_count":462,"id":1044601,"liked":false,"likes_count":462,"name":"牛奶瓶充电暖手宝","price":"55.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/e1m5s9jbw.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/e1m5s9jbw.jpg?imageView2/2/w/720/q/85/format/webp","description":"超级萌萌哒的小夜灯，里面可爱的小龙猫，只要用手轻轻的触摸，就会感应而发光哟~送Ta一个有夜灯陪伴的夜晚，是可以温暖我们内心的存在。","favorites_count":641,"id":1044604,"liked":false,"likes_count":641,"name":"龙猫触摸感应小夜灯","price":"49.30","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/04ciz5ua2.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/04ciz5ua2.jpg?imageView2/2/w/720/q/85/format/webp","description":"这款萌萌哒龙猫眼罩，和一般的眼罩大大的不一样。因为它是可以用USB来加热的，眼罩里面加有天然的薰衣草干花，很有放松的疗效，妥妥的提升睡眠质量，午睡的时候带上这款眼罩，舒适的热感温度，缓解眼睛的不舒服。","favorites_count":969,"id":1045014,"liked":false,"likes_count":969,"name":"USB蒸汽冷热敷龙猫眼罩","price":"75.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160701/i8aqq4jo1_w.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160701/i8aqq4jo1_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"一人专享零食宝盒，39元拥有这个好吃的小世界。有时候，吃货的零食是拒绝分享滴，品尝名额有限，人家只想要做个私享家~","favorites_count":5358,"id":1060734,"liked":false,"likes_count":5358,"name":"味蕾之诗·美味私享家【好吃小世界】","price":"39.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160728/sz0u5p0qn_w.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160728/sz0u5p0qn_w.jpg?imageView2/2/w/720/q/85/format/webp","description":" 一束花，一盒糖，一封信の礼盒。回想起第一次和Ta的见面，遇见你，很开心。 \u201c遇见\u201d花语礼盒上线，18款高颜值进口零食，好吃又美貌， 独家定制\u201c勿忘我\u201d花束礼盒，不凋谢不褪色， 就是这样的永恒，让人永远牢记心中，恰如其名，勿忘我。一整盒的浪漫与心意，统统打包，寄给Ta。","favorites_count":2497,"id":1064547,"liked":false,"likes_count":2497,"name":"味蕾之诗·遇见花语礼盒【遇见你，很开心】","price":"149.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/rc3u7ne6s.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/rc3u7ne6s.jpg?imageView2/2/w/720/q/85/format/webp","description":"简简单单的牛仔色帆布包觉得是百搭的大爱呀~\r\n\r\n不想百搭都不行，\r\n\r\n在个性的时代，\r\n\r\n\u201c我和你不一样\u201d\r\n\r\n第二款也是绝对的个性十足。","favorites_count":1177,"id":1054254,"liked":false,"likes_count":1177,"name":"韩版牛仔帆布包","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160408/56vik16mi.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160408/56vik16mi.jpg?imageView2/2/w/720/q/85/format/webp","description":"造型十分逼真的猫咪抱枕，整个的绘制都是惟妙惟肖哟~喜欢的小伙伴就赶快入手吧。","favorites_count":1261,"id":1054301,"liked":false,"likes_count":1261,"name":"逼真3D猫咪抱枕","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/2hts53trj.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/2hts53trj.jpg?imageView2/2/w/720/q/85/format/webp","description":"土豆兔又名Molang，是一只从韩国远道而来的可爱的兔子。他胖乎乎、短耳朵、短胳膊和短腿，像糯米蛋糕一样圆圆的柔软形象深得大家的喜爱。","favorites_count":1258,"id":1054431,"liked":false,"likes_count":1258,"name":"土豆兔胖兔子公仔暖手抱枕靠垫手捂午休午睡枕靠枕","price":"39.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/5d4oqnhek.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/5d4oqnhek.jpg?imageView2/2/w/720/q/85/format/webp","description":"人人心中都有Totoro，童年就永远不会消失。爱是最美的拥有。","favorites_count":1182,"id":1054554,"liked":false,"likes_count":1182,"name":"Totoro龙猫挂式相框 ","price":"25.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/ys118sgce.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/ys118sgce.jpg?imageView2/2/w/720/q/85/format/webp","description":"卓越音质是一群外表邪恶却内心善良的僵尸猫送给我们的礼物，给我们送来黑暗中的温暖，冷酷中的善良。听音乐让你拒绝外界干扰，全身心投入；玩游戏从细微的脚步声到震撼的爆破场面，都为你逼真还原。还有如此高颜值，也是凹造型的一把好手哦！","favorites_count":1586,"id":1055211,"liked":false,"likes_count":1586,"name":"mr．leaf·魔鬼猫耳机","price":"169.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/79yzz0pqb.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/79yzz0pqb.jpg?imageView2/2/w/720/q/85/format/webp","description":"谁说长大就不能萌萌哒，只要童心未泯，儿童节每天都过！\r\n80、90后你们走过路过，不要错过~\r\n我看你骨骼清奇，天赋异禀，本性纯良，作为吃货必有一番作为。\r\n今日有缘遇见你，来来来，我这里有个宝盒子，你拿去吃吧，\r\n此次经典零食再现江湖，将带你回到一去不复返的小时候。","favorites_count":2612,"id":1055287,"liked":false,"likes_count":2612,"name":"味蕾之诗·小时候童年礼盒","price":"69.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160728/xlknl1bos_w.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160728/xlknl1bos_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"我知道，你心里住着一个小公举，有点调皮，有点温柔，还有些要强。这些甜美的糖果盒蛋糕，香醇甜蜜温暖你的心房。送给Ta外表坚强、内心柔软细腻的Ta，一定准没错哒。","favorites_count":8296,"id":1044985,"liked":false,"likes_count":8296,"name":"味蕾之诗·柔软之心零食大礼盒","price":"99.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/yza79iiha.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/yza79iiha.jpg?imageView2/2/w/720/q/85/format/webp","description":"玫瑰象征爱情，麋鹿象征幸福，手边的玫瑰，心中的麋鹿，对你的喜欢就是这世上永远尝不完的甜，每一种巧克力都是一种专属甜度的美好记忆。来自9个国家，精选23个品牌，将甜蜜的52块巧克力集于一盒。无法拒绝巧克力，就像无法拒绝你。","favorites_count":6295,"id":1048645,"liked":false,"likes_count":6295,"name":"味蕾之诗·52°甜巧克力礼盒","price":"118.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160524/btr276xp3_w.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160524/btr276xp3_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"冷泡咖啡，就是用冷水泡出来的咖啡啦。室温下，咖啡粉浸泡在水里24h。这样会泡出高浓度的液体，用水稀释后冷饮。冷泡咖啡虽相对于西方算新颖，但在日本的Kyoto咖啡，从17世纪就已经流行了。冷泡茶自然也是同理。\r\n下过雨的夏天傍晚， 你可能需要喝点什么。 11种口味冷泡茶饮， 9种风味冷泡咖啡， 挑选、尝试，款款走心。 只用最好喝的冷冲饮消你一夏的暑。 ","favorites_count":3453,"id":1056162,"liked":false,"likes_count":3453,"name":"味蕾之诗·冷冲饮礼盒【冷饮消夏】","price":"79.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/q99134j8b.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/q99134j8b.jpg?imageView2/2/w/720/q/85/format/webp","description":"将抹茶的至醇清新，霓虹的严谨匠心收入一盒，满满的抹茶的香气，让你游荡在抹茶的世界里，从细节体验真日式抹茶风味。","favorites_count":3431,"id":1053235,"liked":false,"likes_count":3431,"name":"味蕾之诗·抹茶控礼盒","price":"119.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160803/757q16lj9.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160803/757q16lj9.jpg?imageView2/2/w/720/q/85/format/webp","description":"什么才能表达出内心的狂喜呢，\r\n\r\n是哈哈哈哈大声狂笑，还是嘚瑟的扭扭屁股？\r\n\r\n在这个喧闹的世间，做个表面安静，内心精彩的新人类~\r\n\r\n你是喜欢hahahhaha呢，\r\n\r\n还是喜欢扭扭扭呢~\r\n\r\n哼\u2026\u2026\r\n\r\n伐开心买个包包压压惊！","favorites_count":1356,"id":1054255,"liked":false,"likes_count":1356,"name":"韩版梦幻纯棉帆布包","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160803/7dfaxkps7.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160803/7dfaxkps7.jpg?imageView2/2/w/720/q/85/format/webp","description":"超浪漫的星空礼盒， 好吃又好玩。独家打造的星空+夜光礼盒，只为将它美好浪漫的一面呈现，星光闪闪无限动人。会发光的礼物， 带着18款人气零食驾到， \u201c陪你一起看星星\u201d。","favorites_count":3197,"id":1064548,"liked":false,"likes_count":3197,"name":"味蕾之诗·星空零食礼盒【会发光的美食】","price":"99.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160728/z7kbnx691_w.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160728/z7kbnx691_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"如果美丽也有甜度，我猜你的味道是马卡龙。在某个慵懒的午后，遇见了被貌美的零食衬得分外甜美的你。记忆中，你永远是那个爱着布朗尼和白色恋人的十八岁少女。\r\n","favorites_count":143,"id":1065898,"liked":false,"likes_count":143,"name":"味蕾之诗·少女心零食礼盒","price":"89.00","purchase_type":1}],"paging":{"next_url":"http://api.liwushuo.com/v2/search/item_by_type?limit=20&offset=20"}}
     * message : OK
     */

    private int code;
    /**
     * items : [{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/8k579o621.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/8k579o621.jpg?imageView2/2/w/720/q/85/format/webp","description":"USB接口的暖手宝，马卡龙色系，随时随地就能保暖~","favorites_count":572,"id":1043991,"liked":false,"likes_count":572,"name":"幸运石马卡龙暖手宝","price":"98.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/cbgfilupt.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/cbgfilupt.jpg?imageView2/2/w/720/q/85/format/webp","description":"很文艺的一款单间包，芥末黄色让你在人群里闪闪动人，陪你逛街、陪你通勤，陪你的小确幸生活里的每一天。","favorites_count":342,"id":1044441,"liked":false,"likes_count":342,"name":"YIZI 手提单肩帆布包","price":"35.20","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/7uxds8i59.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/7uxds8i59.jpg?imageView2/2/w/720/q/85/format/webp","description":"奶瓶外形设计，小巧玲珑，轻轻松松捧在手心。糖果色设计，可以用USB充电加热，很安全的防爆设计。造型实在太可爱了，出门带着上它随时随地暖暖手，过个暖冬就靠它了~","favorites_count":462,"id":1044601,"liked":false,"likes_count":462,"name":"牛奶瓶充电暖手宝","price":"55.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/e1m5s9jbw.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/e1m5s9jbw.jpg?imageView2/2/w/720/q/85/format/webp","description":"超级萌萌哒的小夜灯，里面可爱的小龙猫，只要用手轻轻的触摸，就会感应而发光哟~送Ta一个有夜灯陪伴的夜晚，是可以温暖我们内心的存在。","favorites_count":641,"id":1044604,"liked":false,"likes_count":641,"name":"龙猫触摸感应小夜灯","price":"49.30","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/04ciz5ua2.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/04ciz5ua2.jpg?imageView2/2/w/720/q/85/format/webp","description":"这款萌萌哒龙猫眼罩，和一般的眼罩大大的不一样。因为它是可以用USB来加热的，眼罩里面加有天然的薰衣草干花，很有放松的疗效，妥妥的提升睡眠质量，午睡的时候带上这款眼罩，舒适的热感温度，缓解眼睛的不舒服。","favorites_count":969,"id":1045014,"liked":false,"likes_count":969,"name":"USB蒸汽冷热敷龙猫眼罩","price":"75.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160701/i8aqq4jo1_w.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160701/i8aqq4jo1_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"一人专享零食宝盒，39元拥有这个好吃的小世界。有时候，吃货的零食是拒绝分享滴，品尝名额有限，人家只想要做个私享家~","favorites_count":5358,"id":1060734,"liked":false,"likes_count":5358,"name":"味蕾之诗·美味私享家【好吃小世界】","price":"39.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160728/sz0u5p0qn_w.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160728/sz0u5p0qn_w.jpg?imageView2/2/w/720/q/85/format/webp","description":" 一束花，一盒糖，一封信の礼盒。回想起第一次和Ta的见面，遇见你，很开心。 \u201c遇见\u201d花语礼盒上线，18款高颜值进口零食，好吃又美貌， 独家定制\u201c勿忘我\u201d花束礼盒，不凋谢不褪色， 就是这样的永恒，让人永远牢记心中，恰如其名，勿忘我。一整盒的浪漫与心意，统统打包，寄给Ta。","favorites_count":2497,"id":1064547,"liked":false,"likes_count":2497,"name":"味蕾之诗·遇见花语礼盒【遇见你，很开心】","price":"149.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/rc3u7ne6s.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/rc3u7ne6s.jpg?imageView2/2/w/720/q/85/format/webp","description":"简简单单的牛仔色帆布包觉得是百搭的大爱呀~\r\n\r\n不想百搭都不行，\r\n\r\n在个性的时代，\r\n\r\n\u201c我和你不一样\u201d\r\n\r\n第二款也是绝对的个性十足。","favorites_count":1177,"id":1054254,"liked":false,"likes_count":1177,"name":"韩版牛仔帆布包","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160408/56vik16mi.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160408/56vik16mi.jpg?imageView2/2/w/720/q/85/format/webp","description":"造型十分逼真的猫咪抱枕，整个的绘制都是惟妙惟肖哟~喜欢的小伙伴就赶快入手吧。","favorites_count":1261,"id":1054301,"liked":false,"likes_count":1261,"name":"逼真3D猫咪抱枕","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/2hts53trj.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/2hts53trj.jpg?imageView2/2/w/720/q/85/format/webp","description":"土豆兔又名Molang，是一只从韩国远道而来的可爱的兔子。他胖乎乎、短耳朵、短胳膊和短腿，像糯米蛋糕一样圆圆的柔软形象深得大家的喜爱。","favorites_count":1258,"id":1054431,"liked":false,"likes_count":1258,"name":"土豆兔胖兔子公仔暖手抱枕靠垫手捂午休午睡枕靠枕","price":"39.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/5d4oqnhek.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/5d4oqnhek.jpg?imageView2/2/w/720/q/85/format/webp","description":"人人心中都有Totoro，童年就永远不会消失。爱是最美的拥有。","favorites_count":1182,"id":1054554,"liked":false,"likes_count":1182,"name":"Totoro龙猫挂式相框 ","price":"25.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/ys118sgce.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/ys118sgce.jpg?imageView2/2/w/720/q/85/format/webp","description":"卓越音质是一群外表邪恶却内心善良的僵尸猫送给我们的礼物，给我们送来黑暗中的温暖，冷酷中的善良。听音乐让你拒绝外界干扰，全身心投入；玩游戏从细微的脚步声到震撼的爆破场面，都为你逼真还原。还有如此高颜值，也是凹造型的一把好手哦！","favorites_count":1586,"id":1055211,"liked":false,"likes_count":1586,"name":"mr．leaf·魔鬼猫耳机","price":"169.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img01.liwushuo.com/image/160803/79yzz0pqb.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160803/79yzz0pqb.jpg?imageView2/2/w/720/q/85/format/webp","description":"谁说长大就不能萌萌哒，只要童心未泯，儿童节每天都过！\r\n80、90后你们走过路过，不要错过~\r\n我看你骨骼清奇，天赋异禀，本性纯良，作为吃货必有一番作为。\r\n今日有缘遇见你，来来来，我这里有个宝盒子，你拿去吃吧，\r\n此次经典零食再现江湖，将带你回到一去不复返的小时候。","favorites_count":2612,"id":1055287,"liked":false,"likes_count":2612,"name":"味蕾之诗·小时候童年礼盒","price":"69.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160728/xlknl1bos_w.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160728/xlknl1bos_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"我知道，你心里住着一个小公举，有点调皮，有点温柔，还有些要强。这些甜美的糖果盒蛋糕，香醇甜蜜温暖你的心房。送给Ta外表坚强、内心柔软细腻的Ta，一定准没错哒。","favorites_count":8296,"id":1044985,"liked":false,"likes_count":8296,"name":"味蕾之诗·柔软之心零食大礼盒","price":"99.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/yza79iiha.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/yza79iiha.jpg?imageView2/2/w/720/q/85/format/webp","description":"玫瑰象征爱情，麋鹿象征幸福，手边的玫瑰，心中的麋鹿，对你的喜欢就是这世上永远尝不完的甜，每一种巧克力都是一种专属甜度的美好记忆。来自9个国家，精选23个品牌，将甜蜜的52块巧克力集于一盒。无法拒绝巧克力，就像无法拒绝你。","favorites_count":6295,"id":1048645,"liked":false,"likes_count":6295,"name":"味蕾之诗·52°甜巧克力礼盒","price":"118.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160524/btr276xp3_w.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160524/btr276xp3_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"冷泡咖啡，就是用冷水泡出来的咖啡啦。室温下，咖啡粉浸泡在水里24h。这样会泡出高浓度的液体，用水稀释后冷饮。冷泡咖啡虽相对于西方算新颖，但在日本的Kyoto咖啡，从17世纪就已经流行了。冷泡茶自然也是同理。\r\n下过雨的夏天傍晚， 你可能需要喝点什么。 11种口味冷泡茶饮， 9种风味冷泡咖啡， 挑选、尝试，款款走心。 只用最好喝的冷冲饮消你一夏的暑。 ","favorites_count":3453,"id":1056162,"liked":false,"likes_count":3453,"name":"味蕾之诗·冷冲饮礼盒【冷饮消夏】","price":"79.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160803/q99134j8b.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160803/q99134j8b.jpg?imageView2/2/w/720/q/85/format/webp","description":"将抹茶的至醇清新，霓虹的严谨匠心收入一盒，满满的抹茶的香气，让你游荡在抹茶的世界里，从细节体验真日式抹茶风味。","favorites_count":3431,"id":1053235,"liked":false,"likes_count":3431,"name":"味蕾之诗·抹茶控礼盒","price":"119.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160803/757q16lj9.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160803/757q16lj9.jpg?imageView2/2/w/720/q/85/format/webp","description":"什么才能表达出内心的狂喜呢，\r\n\r\n是哈哈哈哈大声狂笑，还是嘚瑟的扭扭屁股？\r\n\r\n在这个喧闹的世间，做个表面安静，内心精彩的新人类~\r\n\r\n你是喜欢hahahhaha呢，\r\n\r\n还是喜欢扭扭扭呢~\r\n\r\n哼\u2026\u2026\r\n\r\n伐开心买个包包压压惊！","favorites_count":1356,"id":1054255,"liked":false,"likes_count":1356,"name":"韩版梦幻纯棉帆布包","price":"29.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img02.liwushuo.com/image/160803/7dfaxkps7.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160803/7dfaxkps7.jpg?imageView2/2/w/720/q/85/format/webp","description":"超浪漫的星空礼盒， 好吃又好玩。独家打造的星空+夜光礼盒，只为将它美好浪漫的一面呈现，星光闪闪无限动人。会发光的礼物， 带着18款人气零食驾到， \u201c陪你一起看星星\u201d。","favorites_count":3197,"id":1064548,"liked":false,"likes_count":3197,"name":"味蕾之诗·星空零食礼盒【会发光的美食】","price":"99.00","purchase_type":1},{"ad_monitors":[],"cover_image_url":"http://img03.liwushuo.com/image/160728/z7kbnx691_w.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160728/z7kbnx691_w.jpg?imageView2/2/w/720/q/85/format/webp","description":"如果美丽也有甜度，我猜你的味道是马卡龙。在某个慵懒的午后，遇见了被貌美的零食衬得分外甜美的你。记忆中，你永远是那个爱着布朗尼和白色恋人的十八岁少女。\r\n","favorites_count":143,"id":1065898,"liked":false,"likes_count":143,"name":"味蕾之诗·少女心零食礼盒","price":"89.00","purchase_type":1}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/search/item_by_type?limit=20&offset=20"}
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * next_url : http://api.liwushuo.com/v2/search/item_by_type?limit=20&offset=20
         */

        private PagingBean paging;
        /**
         * ad_monitors : []
         * cover_image_url : http://img03.liwushuo.com/image/160803/8k579o621.jpg-w720
         * cover_webp_url : http://img03.liwushuo.com/image/160803/8k579o621.jpg?imageView2/2/w/720/q/85/format/webp
         * description : USB接口的暖手宝，马卡龙色系，随时随地就能保暖~
         * favorites_count : 572
         * id : 1043991
         * liked : false
         * likes_count : 572
         * name : 幸运石马卡龙暖手宝
         * price : 98.00
         * purchase_type : 1
         */

        private List<ItemsBean> items;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ItemsBean{// implements Comparable <ItemsBean>
            private String cover_image_url;
            private String cover_webp_url;
            private String description;
            private int favorites_count;
            private int id;
            private boolean liked;
            private int likes_count;
            private String name;
            private String price;
            private int purchase_type;
            private List<?> ad_monitors;

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getFavorites_count() {
                return favorites_count;
            }

            public void setFavorites_count(int favorites_count) {
                this.favorites_count = favorites_count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isLiked() {
                return liked;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getPurchase_type() {
                return purchase_type;
            }

            public void setPurchase_type(int purchase_type) {
                this.purchase_type = purchase_type;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }



        }
    }
}
