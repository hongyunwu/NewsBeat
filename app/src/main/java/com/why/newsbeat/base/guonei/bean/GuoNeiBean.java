package com.why.newsbeat.base.guonei.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.why.newsbeat.base.detail.DetailApi;

import java.util.List;

/**
 * Created by lenovo on 2017/9/2.
 */

public class GuoNeiBean {

	/**
	 * reason : 成功的返回
	 * result : {"stat":"1","data":[{"uniquekey":"c8711ffee9cb835360382c81fac47922","title":"美军亮出了这个星球上破坏力最强的武器 只为威慑这个国家","date":"2017-09-02 20:50","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902205026510.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_2_mwpm_03200403.jpg"},{"uniquekey":"06cc7ec464ccec4a4f91bf744ebbc209","title":"评论 | 上海警察绊摔事件：对孩子的同情不能\u201c绊倒\u201d对责任的划分","date":"2017-09-02 20:45","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902204509354.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_2_mwpm_03200403.jpg"},{"uniquekey":"d9940d4fba066e50258d43f72c610689","title":"美媒：拟定南海定期巡航计划表，未来数月将进行两三次","date":"2017-09-02 20:43","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902204342318.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902204342_96b543897b7bbe823ca289a4ba3cbac2_1_mwpm_03200403.jpg"},{"uniquekey":"86bab20b9d27db9cb9aaf7aeb518c95a","title":"美国用现实版\u201c哥斯拉\u201d军事施压朝鲜 朝方这样回应","date":"2017-09-02 20:29","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902202920470.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_7_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_5_mwpm_03200403.jpg"},{"uniquekey":"77ca6d318a04b94ee598b666bd5ad21a","title":"稀土永磁昔日妖王霸气回归，中报业绩大增，金九有望暴涨成妖！","date":"2017-09-02 20:22","category":"头条","author_name":"天空的繁星","url":"http://mini.eastday.com/mobile/170902202205510.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_1_mwpm_03200403.jpg"},{"uniquekey":"f1a175bb1d0c245b02cea5b26903f899","title":"我军服役4万吨巨舰，比航母还重要，未来大量装备","date":"2017-09-02 20:21","category":"头条","author_name":"军之讲堂","url":"http://mini.eastday.com/mobile/170902202158900.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170902/20170902_0b09035cb1f71f17d48b5c4b0736614c_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170902/20170902_3d8f2893652baa9447dc7a0bf6b4aaa2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170902/20170902_aceabe2053cd05dd93d67edf9f30b5fd_cover_mwpm_03200403.jpg"},{"uniquekey":"c96631b069e7af8f9ceb5e0bef883030","title":"镜头记录地震后的九寨沟风光","date":"2017-09-02 20:16","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170902201620518.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_4_mwpm_03200403.jpg"},{"uniquekey":"eaf7298ba2cc45eeab827fc8215fa254","title":"天秤座的人总是会不定时的有种孤独感\u2026","date":"2017-09-02 20:12","category":"头条","author_name":"星座物语收录","url":"http://mini.eastday.com/mobile/170902201203882.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902201203_1dcb2856e6b63c090ca302cf67d87894_1_mwpm_03200403.jpg"},{"uniquekey":"b75526e10cf380198c797b2e2a86f85a","title":"向小布什扔了两只鞋的那名记者，现如今怎么样了？","date":"2017-09-02 19:52","category":"头条","author_name":"顶上战狼","url":"http://mini.eastday.com/mobile/170902195256076.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_2_mwpm_03200403.jpg"},{"uniquekey":"7e3c5855885ae16022c2e5744f6b42fb","title":"各种\"币\"都是纯度100%庞氏产品","date":"2017-09-02 19:45","category":"头条","author_name":"荔枝网","url":"http://mini.eastday.com/mobile/170902194511254.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902194511_e4081f1de83da806ffa3bd62acf15331_1_mwpm_03200403.jpg"},{"uniquekey":"358699ac57d26d8a0e09c596eeab1ce9","title":"国防大学下辖北京石家庄上海南京西安等各学院、教学区、校区","date":"2017-09-02 19:41","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902194158007.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902194158_0ce483f3326a7d1afaf78d25f8ca0e23_1_mwpm_03200403.jpg"},{"uniquekey":"4613bb0ebe527adee281949428de86c5","title":"这些姑娘工资近万，工地上班老得快，平时上厕所最尴尬","date":"2017-09-02 19:37","category":"头条","author_name":"文文斌","url":"http://mini.eastday.com/mobile/170902193759255.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_1_mwpm_03200403.jpg"},{"uniquekey":"be30b1cf572ed5ba67f4748a253666dd","title":"鸡蛋我认识，大蒜我认识，但这个我真不认识","date":"2017-09-02 19:37","category":"头条","author_name":"你好面条君","url":"http://mini.eastday.com/mobile/170902193758299.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_5_mwpm_03200403.jpg"},{"uniquekey":"c2075071a93c7fd3d0c5ce35c4ad8a1f","title":"全球飞机离奇失踪的案，现今是个谜，二战飞机数十年后出现在月球？","date":"2017-09-02 19:22","category":"头条","author_name":"一点娱乐","url":"http://mini.eastday.com/mobile/170902192241204.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_1_mwpm_03200403.jpg"},{"uniquekey":"2ae70420f77d30e708b666828e2c80c2","title":"贵州省委副书记谌贻琴任省政府党组书记","date":"2017-09-02 19:20","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902192058976.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902192058_24ff00f11fc6ca6c0cb90929a7016a77_1_mwpm_03200403.jpg"},{"uniquekey":"f89e9d6ceba7b03927f1fe408066f6d6","title":"国防大学军事文化学院改革后首出校门，联合南海舰队举办培训","date":"2017-09-02 19:19","category":"头条","author_name":"微信公号\u201c南海舰队\u201d","url":"http://mini.eastday.com/mobile/170902191954705.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_8_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_7_mwpm_03200403.jpg"},{"uniquekey":"e009e363d414114c7649c64a07ac5ff1","title":"中国总算赶上美30年前水平：数架战机起飞长途奔袭数千公里","date":"2017-09-02 19:15","category":"头条","author_name":"军事枪手","url":"http://mini.eastday.com/mobile/170902191554791.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902_21cd1adf3dcecff27171c8cbb80852d6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902_e7b0a6da4374d993ef9e82740a0218fb_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902_d7a19a735bbaca0e5075c7231214d074_cover_mwpm_03200403.jpg"},{"uniquekey":"87465f750b8a34767897d7718230bc05","title":"小伙子听到自家的楼上有鸟叫声，上去查看之后让他手足无措！","date":"2017-09-02 19:14","category":"头条","author_name":"笑的肚疼","url":"http://mini.eastday.com/mobile/170902191439362.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_3_mwpm_03200403.jpg"},{"uniquekey":"af29c8f41a3e49deb18a53f8c146ba95","title":"土耳其发射导弹袭击叙利亚：俄军迅速出动当人盾 现在还敢打吗？","date":"2017-09-02 19:11","category":"头条","author_name":"军情观察者","url":"http://mini.eastday.com/mobile/170902191150226.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902_ac5e7990f38e7351d30ade7057984af6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170902/20170902_9e061391ae8b18a69e3003b19e14c9b8_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170902/20170902_bd3ac13fc6fe4bfd49073d63e2d3c121_cover_mwpm_03200403.jpg"},{"uniquekey":"c6d59c86060b06db9152bcbc353d963d","title":"美国要借刀杀人？美军举着钱鼓动：印度20万山地军去这个国家送死","date":"2017-09-02 19:05","category":"头条","author_name":"会飞的航母","url":"http://mini.eastday.com/mobile/170902190550966.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170902/20170902_00479462b3a2f81900f4e23182851af0_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170902/20170902_117e185e19ee9209477d256f872b60d2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170902/20170902_90c5848c1cdd5f4946a668b47b5cb9ac_cover_mwpm_03200403.jpg"},{"uniquekey":"61901b723f3c8467434fbff3ada09fe9","title":"难怪手机用久了会那么卡，原来都是这些东西在作怪","date":"2017-09-02 19:02","category":"头条","author_name":"上海天盾数据恢复中心","url":"http://mini.eastday.com/mobile/170902190218340.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_6_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_1_mwpm_03200403.jpg"},{"uniquekey":"cca9f7a32b427c2baedafe1ed91efc3f","title":"CAD软件还没有问世之前，你知道设计师们怎么做的么？","date":"2017-09-02 19:02","category":"头条","author_name":"太原影像","url":"http://mini.eastday.com/mobile/170902190217059.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_6_mwpm_03200403.jpg"},{"uniquekey":"931a02e281bb973196464834e75f8c92","title":"比特币8年400万倍，屡屡创新高，看懂这个对你绝对大有用处！","date":"2017-09-02 18:59","category":"头条","author_name":"脑洞信息","url":"http://mini.eastday.com/mobile/170902185938573.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_3_mwpm_03200403.jpg"},{"uniquekey":"a2ae4fe6883e04fe43867e88ba398b64","title":"这里是全球唯一的钞票市场，家家户户都是亿万富翁，钞票论斤出售","date":"2017-09-02 18:59","category":"头条","author_name":"紫微宝宝的成长记","url":"http://mini.eastday.com/mobile/170902185913694.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_4_mwpm_03200403.jpg"},{"uniquekey":"e2c5a9e5575a23bd1ed229cf3dba2244","title":"娱乐圈老戏骨83岁上吊身亡，生前5种癌症，给妻只留下这三个字！","date":"2017-09-02 18:51","category":"头条","author_name":"时尚全视角","url":"http://mini.eastday.com/mobile/170902185137307.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_4_mwpm_03200403.jpg"},{"uniquekey":"e50dff2ca57c1944522b213cac58570a","title":"张国荣之死已查清 ! 张国荣去世前后全过程揭秘！","date":"2017-09-02 18:51","category":"头条","author_name":"德阳安逸社区","url":"http://mini.eastday.com/mobile/170902185128509.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_9_mwpm_03200403.jpg"},{"uniquekey":"18261cb146a9d5d4d178bfc86eab8edd","title":"泰国女子在日游玩期间突发重病 花费百万要用一生偿还","date":"2017-09-02 18:45","category":"头条","author_name":"东北亚财经","url":"http://mini.eastday.com/mobile/170902184549353.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_1_mwpm_03200403.jpg"},{"uniquekey":"157127b63c9178498fd1aa6cef46cef0","title":"肯尼亚女校发生火灾　至少7人死亡10人受伤","date":"2017-09-02 18:44","category":"头条","author_name":"国搜头条","url":"http://mini.eastday.com/mobile/170902184458234.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902184458_5d9078c5f70023a8969d4f92c32c8092_1_mwpm_03200403.jpg"},{"uniquekey":"0d51bd392059f5f64f1ff4ce6b96b908","title":"台风 \u201c玛娃\u201d明日将登陆广东沿海，国家防总启动三级响应","date":"2017-09-02 18:40","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902184057193.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902184057_b135fe18c5a5506b0618c68269159f87_1_mwpm_03200403.jpg"},{"uniquekey":"11451058452aaa8da83f8bd16ee2a3de","title":"应届生跟马云曾被怀疑干传销，今成身家百亿，帮助马云成亚洲首富","date":"2017-09-02 18:40","category":"头条","author_name":"担扑","url":"http://mini.eastday.com/mobile/170902184038181.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_2_mwpm_03200403.jpg"}]}
	 * error_code : 0
	 */

	private String reason;
	private ResultBean result;
	private int error_code;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public static class ResultBean {
		/**
		 * stat : 1
		 * data : [{"uniquekey":"c8711ffee9cb835360382c81fac47922","title":"美军亮出了这个星球上破坏力最强的武器 只为威慑这个国家","date":"2017-09-02 20:50","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902205026510.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_2_mwpm_03200403.jpg"},{"uniquekey":"06cc7ec464ccec4a4f91bf744ebbc209","title":"评论 | 上海警察绊摔事件：对孩子的同情不能\u201c绊倒\u201d对责任的划分","date":"2017-09-02 20:45","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902204509354.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170902/20170902204509_8fe4f72188300fce059109bb525ad6f7_2_mwpm_03200403.jpg"},{"uniquekey":"d9940d4fba066e50258d43f72c610689","title":"美媒：拟定南海定期巡航计划表，未来数月将进行两三次","date":"2017-09-02 20:43","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902204342318.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902204342_96b543897b7bbe823ca289a4ba3cbac2_1_mwpm_03200403.jpg"},{"uniquekey":"86bab20b9d27db9cb9aaf7aeb518c95a","title":"美国用现实版\u201c哥斯拉\u201d军事施压朝鲜 朝方这样回应","date":"2017-09-02 20:29","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170902202920470.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_7_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902202920_78e83bbcc2353fb57bc41cf534d8bb49_5_mwpm_03200403.jpg"},{"uniquekey":"77ca6d318a04b94ee598b666bd5ad21a","title":"稀土永磁昔日妖王霸气回归，中报业绩大增，金九有望暴涨成妖！","date":"2017-09-02 20:22","category":"头条","author_name":"天空的繁星","url":"http://mini.eastday.com/mobile/170902202205510.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170902/20170902202205_491ebf67165577b8adf411545790a3c2_1_mwpm_03200403.jpg"},{"uniquekey":"f1a175bb1d0c245b02cea5b26903f899","title":"我军服役4万吨巨舰，比航母还重要，未来大量装备","date":"2017-09-02 20:21","category":"头条","author_name":"军之讲堂","url":"http://mini.eastday.com/mobile/170902202158900.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170902/20170902_0b09035cb1f71f17d48b5c4b0736614c_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170902/20170902_3d8f2893652baa9447dc7a0bf6b4aaa2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170902/20170902_aceabe2053cd05dd93d67edf9f30b5fd_cover_mwpm_03200403.jpg"},{"uniquekey":"c96631b069e7af8f9ceb5e0bef883030","title":"镜头记录地震后的九寨沟风光","date":"2017-09-02 20:16","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170902201620518.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902201620_dc00a3277213403778a0248d06111f79_4_mwpm_03200403.jpg"},{"uniquekey":"eaf7298ba2cc45eeab827fc8215fa254","title":"天秤座的人总是会不定时的有种孤独感\u2026","date":"2017-09-02 20:12","category":"头条","author_name":"星座物语收录","url":"http://mini.eastday.com/mobile/170902201203882.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902201203_1dcb2856e6b63c090ca302cf67d87894_1_mwpm_03200403.jpg"},{"uniquekey":"b75526e10cf380198c797b2e2a86f85a","title":"向小布什扔了两只鞋的那名记者，现如今怎么样了？","date":"2017-09-02 19:52","category":"头条","author_name":"顶上战狼","url":"http://mini.eastday.com/mobile/170902195256076.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170902/20170902195256_2fc955c3641ed12dca2acc7b06680d08_2_mwpm_03200403.jpg"},{"uniquekey":"7e3c5855885ae16022c2e5744f6b42fb","title":"各种\"币\"都是纯度100%庞氏产品","date":"2017-09-02 19:45","category":"头条","author_name":"荔枝网","url":"http://mini.eastday.com/mobile/170902194511254.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902194511_e4081f1de83da806ffa3bd62acf15331_1_mwpm_03200403.jpg"},{"uniquekey":"358699ac57d26d8a0e09c596eeab1ce9","title":"国防大学下辖北京石家庄上海南京西安等各学院、教学区、校区","date":"2017-09-02 19:41","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902194158007.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902194158_0ce483f3326a7d1afaf78d25f8ca0e23_1_mwpm_03200403.jpg"},{"uniquekey":"4613bb0ebe527adee281949428de86c5","title":"这些姑娘工资近万，工地上班老得快，平时上厕所最尴尬","date":"2017-09-02 19:37","category":"头条","author_name":"文文斌","url":"http://mini.eastday.com/mobile/170902193759255.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902193759_e2513d04d75f87cb12c91cbfb1529fa1_1_mwpm_03200403.jpg"},{"uniquekey":"be30b1cf572ed5ba67f4748a253666dd","title":"鸡蛋我认识，大蒜我认识，但这个我真不认识","date":"2017-09-02 19:37","category":"头条","author_name":"你好面条君","url":"http://mini.eastday.com/mobile/170902193758299.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902193758_e259a56bb2ddf395545d0fb19fb2a313_5_mwpm_03200403.jpg"},{"uniquekey":"c2075071a93c7fd3d0c5ce35c4ad8a1f","title":"全球飞机离奇失踪的案，现今是个谜，二战飞机数十年后出现在月球？","date":"2017-09-02 19:22","category":"头条","author_name":"一点娱乐","url":"http://mini.eastday.com/mobile/170902192241204.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902192241_3c958ac069e9fb4ceefea9d45bcc41f3_1_mwpm_03200403.jpg"},{"uniquekey":"2ae70420f77d30e708b666828e2c80c2","title":"贵州省委副书记谌贻琴任省政府党组书记","date":"2017-09-02 19:20","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902192058976.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902192058_24ff00f11fc6ca6c0cb90929a7016a77_1_mwpm_03200403.jpg"},{"uniquekey":"f89e9d6ceba7b03927f1fe408066f6d6","title":"国防大学军事文化学院改革后首出校门，联合南海舰队举办培训","date":"2017-09-02 19:19","category":"头条","author_name":"微信公号\u201c南海舰队\u201d","url":"http://mini.eastday.com/mobile/170902191954705.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_8_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170902/20170902191954_ecfe9284b60b43f271f1fd66a207cd8a_7_mwpm_03200403.jpg"},{"uniquekey":"e009e363d414114c7649c64a07ac5ff1","title":"中国总算赶上美30年前水平：数架战机起飞长途奔袭数千公里","date":"2017-09-02 19:15","category":"头条","author_name":"军事枪手","url":"http://mini.eastday.com/mobile/170902191554791.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902_21cd1adf3dcecff27171c8cbb80852d6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902_e7b0a6da4374d993ef9e82740a0218fb_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902_d7a19a735bbaca0e5075c7231214d074_cover_mwpm_03200403.jpg"},{"uniquekey":"87465f750b8a34767897d7718230bc05","title":"小伙子听到自家的楼上有鸟叫声，上去查看之后让他手足无措！","date":"2017-09-02 19:14","category":"头条","author_name":"笑的肚疼","url":"http://mini.eastday.com/mobile/170902191439362.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902191439_4b91d2294606bfc0942185b601fe5641_3_mwpm_03200403.jpg"},{"uniquekey":"af29c8f41a3e49deb18a53f8c146ba95","title":"土耳其发射导弹袭击叙利亚：俄军迅速出动当人盾 现在还敢打吗？","date":"2017-09-02 19:11","category":"头条","author_name":"军情观察者","url":"http://mini.eastday.com/mobile/170902191150226.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170902/20170902_ac5e7990f38e7351d30ade7057984af6_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170902/20170902_9e061391ae8b18a69e3003b19e14c9b8_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170902/20170902_bd3ac13fc6fe4bfd49073d63e2d3c121_cover_mwpm_03200403.jpg"},{"uniquekey":"c6d59c86060b06db9152bcbc353d963d","title":"美国要借刀杀人？美军举着钱鼓动：印度20万山地军去这个国家送死","date":"2017-09-02 19:05","category":"头条","author_name":"会飞的航母","url":"http://mini.eastday.com/mobile/170902190550966.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170902/20170902_00479462b3a2f81900f4e23182851af0_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170902/20170902_117e185e19ee9209477d256f872b60d2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170902/20170902_90c5848c1cdd5f4946a668b47b5cb9ac_cover_mwpm_03200403.jpg"},{"uniquekey":"61901b723f3c8467434fbff3ada09fe9","title":"难怪手机用久了会那么卡，原来都是这些东西在作怪","date":"2017-09-02 19:02","category":"头条","author_name":"上海天盾数据恢复中心","url":"http://mini.eastday.com/mobile/170902190218340.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_5_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_6_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170902/20170902190218_8e22beae37add214586dabf178da5fc6_1_mwpm_03200403.jpg"},{"uniquekey":"cca9f7a32b427c2baedafe1ed91efc3f","title":"CAD软件还没有问世之前，你知道设计师们怎么做的么？","date":"2017-09-02 19:02","category":"头条","author_name":"太原影像","url":"http://mini.eastday.com/mobile/170902190217059.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_5_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902190217_9a9580f07f7ad216df16d6493279296a_6_mwpm_03200403.jpg"},{"uniquekey":"931a02e281bb973196464834e75f8c92","title":"比特币8年400万倍，屡屡创新高，看懂这个对你绝对大有用处！","date":"2017-09-02 18:59","category":"头条","author_name":"脑洞信息","url":"http://mini.eastday.com/mobile/170902185938573.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170902/20170902185938_c77d18b3a11d2fcd30badf26325d4fa2_3_mwpm_03200403.jpg"},{"uniquekey":"a2ae4fe6883e04fe43867e88ba398b64","title":"这里是全球唯一的钞票市场，家家户户都是亿万富翁，钞票论斤出售","date":"2017-09-02 18:59","category":"头条","author_name":"紫微宝宝的成长记","url":"http://mini.eastday.com/mobile/170902185913694.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170902/20170902185913_ddd100a2e47f78a3788e9a0b024ce8e7_4_mwpm_03200403.jpg"},{"uniquekey":"e2c5a9e5575a23bd1ed229cf3dba2244","title":"娱乐圈老戏骨83岁上吊身亡，生前5种癌症，给妻只留下这三个字！","date":"2017-09-02 18:51","category":"头条","author_name":"时尚全视角","url":"http://mini.eastday.com/mobile/170902185137307.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170902/20170902185137_b4c4c5009416f1bad1b94350a74ee2c0_4_mwpm_03200403.jpg"},{"uniquekey":"e50dff2ca57c1944522b213cac58570a","title":"张国荣之死已查清 ! 张国荣去世前后全过程揭秘！","date":"2017-09-02 18:51","category":"头条","author_name":"德阳安逸社区","url":"http://mini.eastday.com/mobile/170902185128509.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_6_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902185128_20b620f5729802d2ccec6e2e407bdbe3_9_mwpm_03200403.jpg"},{"uniquekey":"18261cb146a9d5d4d178bfc86eab8edd","title":"泰国女子在日游玩期间突发重病 花费百万要用一生偿还","date":"2017-09-02 18:45","category":"头条","author_name":"东北亚财经","url":"http://mini.eastday.com/mobile/170902184549353.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170902/20170902184549_e3066bb23e27c5136e3c157de8e41aae_1_mwpm_03200403.jpg"},{"uniquekey":"157127b63c9178498fd1aa6cef46cef0","title":"肯尼亚女校发生火灾　至少7人死亡10人受伤","date":"2017-09-02 18:44","category":"头条","author_name":"国搜头条","url":"http://mini.eastday.com/mobile/170902184458234.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170902/20170902184458_5d9078c5f70023a8969d4f92c32c8092_1_mwpm_03200403.jpg"},{"uniquekey":"0d51bd392059f5f64f1ff4ce6b96b908","title":"台风 \u201c玛娃\u201d明日将登陆广东沿海，国家防总启动三级响应","date":"2017-09-02 18:40","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170902184057193.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170902/20170902184057_b135fe18c5a5506b0618c68269159f87_1_mwpm_03200403.jpg"},{"uniquekey":"11451058452aaa8da83f8bd16ee2a3de","title":"应届生跟马云曾被怀疑干传销，今成身家百亿，帮助马云成亚洲首富","date":"2017-09-02 18:40","category":"头条","author_name":"担扑","url":"http://mini.eastday.com/mobile/170902184038181.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170902/20170902184038_e12dbfd5962df618637041bfb995d2ad_2_mwpm_03200403.jpg"}]
		 */

		private String stat;
		private List<DataBean> data;

		public String getStat() {
			return stat;
		}

		public void setStat(String stat) {
			this.stat = stat;
		}

		public List<DataBean> getData() {
			return data;
		}

		public void setData(List<DataBean> data) {
			this.data = data;
		}

		public static class DataBean implements Parcelable,DetailApi {
			/**
			 * uniquekey : c8711ffee9cb835360382c81fac47922
			 * title : 美军亮出了这个星球上破坏力最强的武器 只为威慑这个国家
			 * date : 2017-09-02 20:50
			 * category : 头条
			 * author_name : 央视网
			 * url : http://mini.eastday.com/mobile/170902205026510.html
			 * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_4_mwpm_03200403.jpg
			 * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_1_mwpm_03200403.jpg
			 * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20170902/20170902205026_df5465888835e1c1052f4c0059190cba_2_mwpm_03200403.jpg
			 */

			private String uniquekey;
			private String title;
			private String date;
			private String category;
			private String author_name;
			private String url;
			private String thumbnail_pic_s;
			private String thumbnail_pic_s02;
			private String thumbnail_pic_s03;

			public String getUniquekey() {
				return uniquekey;
			}

			public void setUniquekey(String uniquekey) {
				this.uniquekey = uniquekey;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}

			public String getAuthor_name() {
				return author_name;
			}

			public void setAuthor_name(String author_name) {
				this.author_name = author_name;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getThumbnail_pic_s() {
				return thumbnail_pic_s;
			}

			public void setThumbnail_pic_s(String thumbnail_pic_s) {
				this.thumbnail_pic_s = thumbnail_pic_s;
			}

			public String getThumbnail_pic_s02() {
				return thumbnail_pic_s02;
			}

			public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
				this.thumbnail_pic_s02 = thumbnail_pic_s02;
			}

			public String getThumbnail_pic_s03() {
				return thumbnail_pic_s03;
			}

			public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
				this.thumbnail_pic_s03 = thumbnail_pic_s03;
			}

			/**
			 * 默认返回0即可
			 *
			 * @return
			 */
			@Override
			public int describeContents() {
				return 0;
			}



			@Override
			public void writeToParcel(Parcel dest, int flags) {
				dest.writeString(uniquekey);
				dest.writeString(title);
				dest.writeString(date);
				dest.writeString(category);
				dest.writeString(author_name);
				dest.writeString(url);
				dest.writeString(thumbnail_pic_s);
				dest.writeString(thumbnail_pic_s02);
				dest.writeString(thumbnail_pic_s03);
			}

			public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
				@Override
				public DataBean createFromParcel(Parcel source) {
					return new DataBean(source);
				}

				@Override
				public DataBean[] newArray(int size) {
					return new DataBean[size];
				}
			};

			public DataBean(Parcel source) {
				uniquekey = source.readString();
				title = source.readString();
				date = source.readString();
				category = source.readString();
				author_name = source.readString();
				url = source.readString();
				thumbnail_pic_s = source.readString();
				thumbnail_pic_s02 = source.readString();
				thumbnail_pic_s03 = source.readString();
			}
		}
	}
}
