package com.example.composetest2.logic

import android.annotation.SuppressLint

val AlphabetList = listOf<List<String>>(
    "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p Q q R r S s T t U u V v W w X x Y y Z z 1 2 3 4 5 6 7 8 9 0".split(" "),
    "\uD835\uDC00 \uD835\uDC1A \uD835\uDC01 \uD835\uDC1B \uD835\uDC02 \uD835\uDC1C \uD835\uDC03 \uD835\uDC1D \uD835\uDC04 \uD835\uDC1E \uD835\uDC05 \uD835\uDC1F \uD835\uDC06 \uD835\uDC20 \uD835\uDC07 \uD835\uDC21 \uD835\uDC08 \uD835\uDC22 \uD835\uDC09 \uD835\uDC23 \uD835\uDC0A \uD835\uDC24 \uD835\uDC0B \uD835\uDC25 \uD835\uDC0C \uD835\uDC26 \uD835\uDC0D \uD835\uDC27 \uD835\uDC0E \uD835\uDC28 \uD835\uDC0F \uD835\uDC29 \uD835\uDC10 \uD835\uDC2A \uD835\uDC11 \uD835\uDC2B \uD835\uDC12 \uD835\uDC2C \uD835\uDC13 \uD835\uDC2D \uD835\uDC14 \uD835\uDC2E \uD835\uDC15 \uD835\uDC2F \uD835\uDC16 \uD835\uDC30 \uD835\uDC17 \uD835\uDC31 \uD835\uDC18 \uD835\uDC32 \uD835\uDC19 \uD835\uDC33 \uD835\uDFCF \uD835\uDFD0 \uD835\uDFD1 \uD835\uDFD2 \uD835\uDFD3 \uD835\uDFD4 \uD835\uDFD5 \uD835\uDFD6 \uD835\uDFD7 \uD835\uDFCE".split(" "),
    "\uD835\uDD38 \uD835\uDD52 \uD835\uDD39 \uD835\uDD53 ℂ \uD835\uDD54 \uD835\uDD3B \uD835\uDD55 \uD835\uDD3C \uD835\uDD56 \uD835\uDD3D \uD835\uDD57 \uD835\uDD3E \uD835\uDD58 ℍ \uD835\uDD59 \uD835\uDD40 \uD835\uDD5A \uD835\uDD41 \uD835\uDD5B \uD835\uDD42 \uD835\uDD5C \uD835\uDD43 \uD835\uDD5D \uD835\uDD44 \uD835\uDD5E ℕ \uD835\uDD5F \uD835\uDD46 \uD835\uDD60 ℙ \uD835\uDD61 ℚ \uD835\uDD62 ℝ \uD835\uDD63 \uD835\uDD4A \uD835\uDD64 \uD835\uDD4B \uD835\uDD65 \uD835\uDD4C \uD835\uDD66 \uD835\uDD4D \uD835\uDD67 \uD835\uDD4E \uD835\uDD68 \uD835\uDD4F \uD835\uDD69 \uD835\uDD50 \uD835\uDD6A ℤ \uD835\uDD6B \uD835\uDFD9 \uD835\uDFDA \uD835\uDFDB \uD835\uDFDC \uD835\uDFDD \uD835\uDFDE \uD835\uDFDF \uD835\uDFE0 \uD835\uDFE1 \uD835\uDFD8".split(" "),
    "\uD835\uDD6C \uD835\uDD86 \uD835\uDD6D \uD835\uDD87 \uD835\uDD6E \uD835\uDD88 \uD835\uDD6F \uD835\uDD89 \uD835\uDD70 \uD835\uDD8A \uD835\uDD71 \uD835\uDD8B \uD835\uDD72 \uD835\uDD8C \uD835\uDD73 \uD835\uDD8D \uD835\uDD74 \uD835\uDD8E \uD835\uDD75 \uD835\uDD8F \uD835\uDD76 \uD835\uDD90 \uD835\uDD77 \uD835\uDD91 \uD835\uDD78 \uD835\uDD92 \uD835\uDD79 \uD835\uDD93 \uD835\uDD7A \uD835\uDD94 \uD835\uDD7B \uD835\uDD95 \uD835\uDD7C \uD835\uDD96 \uD835\uDD7D \uD835\uDD97 \uD835\uDD7E \uD835\uDD98 \uD835\uDD7F \uD835\uDD99 \uD835\uDD80 \uD835\uDD9A \uD835\uDD81 \uD835\uDD9B \uD835\uDD82 \uD835\uDD9C \uD835\uDD83 \uD835\uDD9D \uD835\uDD84 \uD835\uDD9E \uD835\uDD85 \uD835\uDD9F \uD835\uDFCF \uD835\uDFD0 \uD835\uDFD1 \uD835\uDFD2 \uD835\uDFD3 \uD835\uDFD4 \uD835\uDFD5 \uD835\uDFD6 \uD835\uDFD7 \uD835\uDFCE".split(" "),
    "\uD835\uDC68 \uD835\uDC82 \uD835\uDC69 \uD835\uDC83 \uD835\uDC6A \uD835\uDC84 \uD835\uDC6B \uD835\uDC85 \uD835\uDC6C \uD835\uDC86 \uD835\uDC6D \uD835\uDC87 \uD835\uDC6E \uD835\uDC88 \uD835\uDC6F \uD835\uDC89 \uD835\uDC70 \uD835\uDC8A \uD835\uDC71 \uD835\uDC8B \uD835\uDC72 \uD835\uDC8C \uD835\uDC73 \uD835\uDC8D \uD835\uDC74 \uD835\uDC8E \uD835\uDC75 \uD835\uDC8F \uD835\uDC76 \uD835\uDC90 \uD835\uDC77 \uD835\uDC91 \uD835\uDC78 \uD835\uDC92 \uD835\uDC79 \uD835\uDC93 \uD835\uDC7A \uD835\uDC94 \uD835\uDC7B \uD835\uDC95 \uD835\uDC7C \uD835\uDC96 \uD835\uDC7D \uD835\uDC97 \uD835\uDC7E \uD835\uDC98 \uD835\uDC7F \uD835\uDC99 \uD835\uDC80 \uD835\uDC9A \uD835\uDC81 \uD835\uDC9B \uD835\uDFCF \uD835\uDFD0 \uD835\uDFD1 \uD835\uDFD2 \uD835\uDFD3 \uD835\uDFD4 \uD835\uDFD5 \uD835\uDFD6 \uD835\uDFD7 \uD835\uDFCE".split(" "),
    "\uD83C\uDD30 \uD83C\uDD30 \uD83C\uDD31 \uD83C\uDD31 \uD83C\uDD32 \uD83C\uDD32 \uD83C\uDD33 \uD83C\uDD33 \uD83C\uDD34 \uD83C\uDD34 \uD83C\uDD35 \uD83C\uDD35 \uD83C\uDD36 \uD83C\uDD36 \uD83C\uDD37 \uD83C\uDD37 \uD83C\uDD38 \uD83C\uDD38 \uD83C\uDD39 \uD83C\uDD39 \uD83C\uDD3A \uD83C\uDD3A \uD83C\uDD3B \uD83C\uDD3B \uD83C\uDD3C \uD83C\uDD3C \uD83C\uDD3D \uD83C\uDD3D \uD83C\uDD3E \uD83C\uDD3E \uD83C\uDD3F \uD83C\uDD3F \uD83C\uDD40 \uD83C\uDD40 \uD83C\uDD41 \uD83C\uDD41 \uD83C\uDD42 \uD83C\uDD42 \uD83C\uDD43 \uD83C\uDD43 \uD83C\uDD44 \uD83C\uDD44 \uD83C\uDD45 \uD83C\uDD45 \uD83C\uDD46 \uD83C\uDD46 \uD83C\uDD47 \uD83C\uDD47 \uD83C\uDD48 \uD83C\uDD48 \uD83C\uDD49 \uD83C\uDD49 1 2 3 4 5 6 7 8 9 0".split(" "),
    "\uD83C\uDD70 \uD83C\uDD70 \uD83C\uDD71 \uD83C\uDD71 \uD83C\uDD72 \uD83C\uDD72 \uD83C\uDD73 \uD83C\uDD73 \uD83C\uDD74 \uD83C\uDD74 \uD83C\uDD75 \uD83C\uDD75 \uD83C\uDD76 \uD83C\uDD76 \uD83C\uDD77 \uD83C\uDD77 \uD83C\uDD78 \uD83C\uDD78 \uD83C\uDD79 \uD83C\uDD79 \uD83C\uDD7A \uD83C\uDD7A \uD83C\uDD7B \uD83C\uDD7B \uD83C\uDD7C \uD83C\uDD7C \uD83C\uDD7D \uD83C\uDD7D \uD83C\uDD7E \uD83C\uDD7E \uD83C\uDD7F \uD83C\uDD7F \uD83C\uDD80 \uD83C\uDD80 \uD83C\uDD81 \uD83C\uDD81 \uD83C\uDD82 \uD83C\uDD82 \uD83C\uDD83 \uD83C\uDD83 \uD83C\uDD84 \uD83C\uDD84 \uD83C\uDD85 \uD83C\uDD85 \uD83C\uDD86 \uD83C\uDD86 \uD83C\uDD87 \uD83C\uDD87 \uD83C\uDD88 \uD83C\uDD88 \uD83C\uDD89 \uD83C\uDD89 \uD835\uDFCF \uD835\uDFD0 \uD835\uDFD1 \uD835\uDFD2 \uD835\uDFD3 \uD835\uDFD4 \uD835\uDFD5 \uD835\uDFD6 \uD835\uDFD7 \uD835\uDFCE".split(" "),
    "Ⓐ ⓐ Ⓑ ⓑ Ⓒ ⓒ Ⓓ ⓓ Ⓔ ⓔ Ⓕ ⓕ Ⓖ ⓖ Ⓗ ⓗ Ⓘ ⓘ Ⓙ ⓙ Ⓚ ⓚ Ⓛ ⓛ Ⓜ ⓜ Ⓝ ⓝ Ⓞ ⓞ Ⓟ ⓟ Ⓠ ⓠ Ⓡ ⓡ Ⓢ ⓢ Ⓣ ⓣ Ⓤ ⓤ Ⓥ ⓥ Ⓦ ⓦ Ⓧ ⓧ Ⓨ ⓨ Ⓩ ⓩ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ 0".split(" "),
    "\uD83C\uDD50 \uD83C\uDD50 \uD83C\uDD51 \uD83C\uDD51 \uD83C\uDD52 \uD83C\uDD52 \uD83C\uDD53 \uD83C\uDD53 \uD83C\uDD54 \uD83C\uDD54 \uD83C\uDD55 \uD83C\uDD55 \uD83C\uDD56 \uD83C\uDD56 \uD83C\uDD57 \uD83C\uDD57 \uD83C\uDD58 \uD83C\uDD58 \uD83C\uDD59 \uD83C\uDD59 \uD83C\uDD5A \uD83C\uDD5A \uD83C\uDD5B \uD83C\uDD5B \uD83C\uDD5C \uD83C\uDD5C \uD83C\uDD5D \uD83C\uDD5D \uD83C\uDD5E \uD83C\uDD5E \uD83C\uDD5F \uD83C\uDD5F \uD83C\uDD60 \uD83C\uDD60 \uD83C\uDD61 \uD83C\uDD61 \uD83C\uDD62 \uD83C\uDD62 \uD83C\uDD63 \uD83C\uDD63 \uD83C\uDD64 \uD83C\uDD64 \uD83C\uDD65 \uD83C\uDD65 \uD83C\uDD66 \uD83C\uDD66 \uD83C\uDD67 \uD83C\uDD67 \uD83C\uDD68 \uD83C\uDD68 \uD83C\uDD69 \uD83C\uDD69 \uD835\uDFCF \uD835\uDFD0 \uD835\uDFD1 \uD835\uDFD2 \uD835\uDFD3 \uD835\uDFD4 \uD835\uDFD5 \uD835\uDFD6 \uD835\uDFD7 \uD835\uDFCE".split(" "),
    "0 6 8 ㄥ 9 ގ ㄣ Ɛ ᄅ ⇂ z Z ʎ ⅄ x X ʍ M ʌ Λ n ∩ ʇ ⊥ s S ɹ ᴚ b Ό d Ԁ o O u N ɯ W l ˥ ʞ ⋊ ɾ ſ ı I ɥ H ɓ ⅁ ɟ Ⅎ ǝ Ǝ p ᗡ ɔ Ɔ q ᙠ ɐ ∀".reversed().split(" "),
)

val DecorationLeft = listOf(
    "●●--●●◄⚽️►", "✈️─═∙∙∙▫▫ᵒᴼᵒ▫._", "🎧♪┏(°.°)┛🎼", "◄[🏆]► ", "꧁✿🌸╭⊱", "[ꔊꔊꔊ[🍉]", "▂▃▅▇█▓▒░ ", "╰⊱♥⊱╮ღ꧁", "/¯°•º¤ϟϞ҂", "★彡", "·٠•●♥ Ƹ̵̡Ӝ̵̨̄Ʒ ♥●•٠·˙", "o͡͡͡͡͡͡͡͡͡͡͡͡͡͡╮(｡❛ᴗ❛｡)╭o͡͡͡͡͡͡͡͡͡͡͡͡͡͡  ", "▌│█║▌║▌║", "◇─◇──◇────◇", "★·.·¯`·.·★", "☆彡彡", "★彡彡", "人人人", "¯\\_(ツ)_/¯", "»»——☠——«", "★━━─ ", "■━■━■━■", "︵‿︵‿︵‿︵‿︵", "╭─━━━━━─╯", "┏━━━━━━┛", "└╏ ･", "├┬┴┬┴", "┕━━━━ ⋆⋅☆⋅⋆ ━━┑", "┕━━━━✿━━┑", "↤↤↤↤↤", "➶➶➶➶➶", "↫↫↫↫↫", "✎✐✎✐✎", "■■■■■■■■□□□", "░▒▓█", "★・・・・・・★", "█▓▒░", "»»————-", "✼　 ҉   ", "☆━━━━━━☆", "●～●～", "・‥…━━━━━━━☆", "【☆】★【☆】", "◇─◇──◇────◇", "☆❋──❁ ", "▁ ▂ ▄ ▅ ▆ ▇ █", "▂▃▄▅▆▇▉▉[", "▂▃▅▇█▓▒░", "▉▇▆▅▄▃▂▂▂_", "ღ꧁ღ╭⊱ꕥ", "─═ڿڰۣڿ☻ڿڰۣڿ═─", "╰⊱♥⊱╮ღ꧁", "╰⊱♥⊱╮╰⊱♥⊱╮", "✧∭✧∰✧∭✧", "●▬▬▬๑۩۩๑▬▬▬●", "/¯°•º¤ϟϞ҂ ", "(¯`·._.· ", "¨°o.O", "×÷·.·´¯`·)»", "· ··^v´¯`×)", ".·´¯`·-> ", "- - --^[", "(¯`·»o«·´¯`·>", ").•ˆ•+*¨", "•·.·¯`·.·•", "(¯`·._)", "·°¯`·•", ".ҳ̸Ҳ̸Ҳ̸ҳ•.•´¯`•", "×º°”˜`”°º×", "•]•·´º´·»", "°•. °•. °•.", "エｴｪｪｪ", "(`·.·•", "【★】", "•°o.O", "©º°¨¨°º©", "°·.¸.·°¯°·.¸.-<", "•°l¯l_l¯l*", "—(•·÷[", "·ï¡÷¡ï·", "εїз", "•°•.•°•", "|¯|_|¯|_.°•. °•.-> ", "꒰◍•ᴗ•◍꒱", "(^^(-_-)^^)", "¸.´)(`·[", "---»--@-}", "(¯`·._(¯`·._(¯`·._", "•]•·✦º✦·»", ";`';_._;`';_.", "-♥-♡--^[", "◄]·♦·»", "-·=»★«=·-", "★·.·¯`·.·★", "-·●·♦^v¯`♦)", "(★)(¯`·.●.●", "●●--●●--●●", "★★.·¯`★", "╱(●_●)(^_^)", "♪•]•·º♫·》»", "••.•´¯`•.••", "|!¤*'~``~'*¤!||", "°•.•°o.O", "––––º•(-º", "ҳ̸Ҳ̸Ҳ̸ҳ(¯`·.•.", "◄°l||l°", "°l||l°►", "·∙·÷±‡±:∙", "(¯`v^÷••", "··●(`●-", "¯`-●=»>◆<«=●", "ø´¯`·¤»", "●·(¯¨°¹●.", "º¯`·.·•", "«(.·°¯`·->", "‹–…·´`·…–›", ".·´`·.·´¯`·.›", "(¯(_(¯`•", "[.·´¯`·.]", "ì..·´`•", "¯°•º¤◆¤º°¯", "‹—•°º¤°(", "<.•ˆ•…", "‹‹¡Ì›–•¦[", "●·(¯¨°¹●.", "¯`·.__.·´¯»", "_/¯/__/¯/_ ", "‹v^v^v^•", "•°¤*´¯`*¤°•", ".·´`·.·´¯`·.›", "<--•´`·.·´`•", "–--´¯`----»", "{¯`·._.• .·´«", "╱╲╱╳╲╱╲", "╚╝╔╗╚╝╔╗", "╭╮╰╯╭╮╰╯", "´¯`*¤.·´`·.¤", "‹—•((.•ˆ•…", "÷(`•´`·.", "»-(¯`v´¯)-»", "ıllıllı", "*•.¸♡", "¸„.-•~¹°”ˆ˜¨ ", "★彡", "`•.,¸¸,.•´¯", "·.¸¸.·♩♪♫", "-漫~*'¨¯¨'*·舞~", "◦•●◉✿", "╚»★«╝", "╚»♡«╝", "´*•.¸(*•.¸♥¸.•*´)¸.•*´", "▄▀▀▄▀▀▄", "▀▄▀▄▀▄", "╭₪₪₪", "✖✖✖✖", "·٠•●♥ Ƹ̵̡Ӝ̵̨̄Ʒ ♥●•٠·˙", "[]ðº°˜¨˜°ºð[]", "●¸.•*¨Ƹ̵̡Ӝ̵̨̄Ʒ¨*•.¸●", "╔╣█╠╗╚", ".--ღஐƸ̵̡Ӝ̵̨̄Ʒஐღ--.", "⊱━━━.⋅εïз⋅.━━━⊰", "/)/)/)/)/)/)", "*̥̻̥̻̥͙*̻̥̻̥͙*̥̻̥͙*̻̥͙*̥͙ ", "((*´_●｀☆ﾟ+.", "ヾ(>u<●【*:..｡o○", "ᨏᨐᨓ", "⇇⇇⇇", "⇉⇉⇉", "︹︺︹︺ ", "¸.•*¨*•.¸♪¸.•*¨*•.¸♥¸.•*¨*•.¸", "◦•●◉✿", ".•♫•♬•", "ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙∙∙∙", "((¯*.».( ¯*♥ » ", "⚡️¯\\_༼ ಥ ‿ ಥ ༽_/¯⚡", "o͡͡͡͡͡͡͡͡͡͡͡͡͡͡╮(｡❛ᴗ❛｡)╭o͡͡͡͡͡͡͡͡͡͡͡͡͡͡  ", "(◦′ᆺ‵◦) ♬° ✧❥✧¸.•*¨*✧♡✧", "჻ღཾཿ༉ ༘჻ღཾཿ༉ ༘჻ღཾཿ༉ ༘჻ღཾཿ჻", "୧༼ಠ益ಠ༽︻╦╤─", "‿︵‿︵(ಥ﹏ಥ)‿︵‿︵", "̿ ̿ ̿'̿'\\̵͇̿̿\\з=(•_•)=ε/̵͇̿̿/'̿'̿ ̿ ", "｢(◔ω◔「)三 ", "ԅ[ •́ ﹏├┬┴┬┴ ", "☆(ﾉ^o^)ﾉ‥‥", "＼＼\\(۶•̀ᴗ•́)۶//／／ ", "~-<🌴>-~", "~~<💚>~~ ", "~~><~~>💖", "─═ڿڿۣڿ═─💖─═ڿڿۣڿ═─ ", "༺♥༻❀༺♥༻💕", "💢🚀🚀💢 ", "💗💜.¸¸.•´¯`☆ºஇ•´♥ ", "╰☆⭐️", "【🌩】★【🌩】 ", "🎄✖🎄✖🎄⇉", "🌈ꔣᨐ", "🌨❄•°•.•°• ", "·°¯`·•🌹■🌼■🌸ꕥ", "╭₪🍔₪🍟₪", "꧁✿🌸╭⊱", "︾︽🍍︾︽", "🎧♪┏(°.°)┛🎼", "෴❤️෴", "░▒▒ 💀 ▒▒░", "ᆛᆜᆛᆜ", "ᎲᎲᎲᎲ", "ᙀᙁᙀᙁᙀᙁ", "ဿဿဿ", "൪൪൪൪൪൪", "ഐഐഐ", "ߐߐߐߐߐߐߐߐߐߐ", "ߖܠߖܠߖܠߖܠߖܠ", "ⴍⴖⴍⴖⴍⴖⴍⴖ", "ਸਸਸਸਸਸਸਸ", "ਔਔਔਔਔਔਔ", "ⰎⰎⰎⰎ", "⭜⭝⭜⭝⭜⭝", "✔✓✔✓✔", "ᱰᱰᱰᱰᱰᱰ", "ᙠᙝᙠᙝᙠᙝ", "ဣဣဣဣဣဣ", "႑႑႑႑႑႑႑႑႑", "႘႙႘႙႘႙႘႙႘႙", "༼༽༼༽༼༽༼༽", "ంంంం", "২২২২২২২২", "ਠਠਠਠਠਠਠਠਠ", "ܛܛܛܛܛܛܛܛܛ", "ܓܓܓܓܓܓܓܓ", "ㄣㄣㄣㄣ", "✘✗✘✗✘✗", "✚✚✚✚✚✚", "ᱬᱬᱬᱬ", "ᨎᨎᨎᨎᨎᨎ", "ᨁᨁᨁᨁ", "ᆇᆇᆇᆇᆇ", "ᆛᆛᆛᆛᆛᆛ", "႔႔႔႔႔႔႔", "ഹഹഹഹ", "⼐⼌⼐⼌⼐⼌⼐⼌", "᚛᚜᚛᚜᚛᚜᚛᚜᚛᚜", "⯊⯋⯊⯋⯊⯋", "ᕳᕲ", "ᔐᔑᔐᔑᔐᔑ", "웃❤유", "░║", "⊑⊗⊒", "⊄⊅⊆", "⊼⊻⊼⊻", "≪∅≫", ">>--» [[", "﹀︽︾△︾︽﹀", "﹀︽︾", "༺", "✩", "⦕", "╰┈⫸", "༺ 𒆜", "𒆜", "◦•●◉", "♢○○", "♜", "✭", "乂", "⫷", "❚█══", "✫", "☜☆☞", "꧁༺", "꧁ঔৣ☬✞", "✞✞✞", "☬", "▄︻┻═┳一", "╾━╤デ╦︻", "۞", "꧁*", "꧁ঔৣ", "☆☬", "☆《《", "◌●♡♡", "《《", "❂⁂", "⇙↜ꐠ", "︽₪៛", "❅", "⁎⁑⁂", "↜ꐠ", "*★*:;;;;;:*★*", "*☆*――*☆*", "*:..。o○☆○o。..:*", "○*:;;;:*○", "｡+ﾟ☆ﾟ+｡★", "★゜・。。・゜゜・。。・゜", "★━━━━━", "*†*†*†*†*†*", "☆(´・ω・)★☆", "☆*ﾟ ゜ﾟ*☆", "☆::::::::::::::::", "■□■□■□■□■", "○●○●○●○●○", "(｡>ωω<｡)", "◆´・ω・◆", "★*ﾟ*☆*ﾟ*★", "♡o｡.｡o♡", "оО〇・-・〇Оо", "[̲̅$̲̅(̲̅ιοο̲̅)̲̅$̲̅]", "︻̷ ┻ ═━一", "♫´¨`•*", "┌∩┐(◣_◢)┌∩┐", "︻╦╤─", "<:::::::::::::[==()", "ˁ˚ᴥ˚ˀ", "( . Y . )", "︻┳デ═—", "✯╾━╤デ╦︻✯", "๑۩ﺴ۩๑", "๑۩۞۩๑", "๑•ิ.•ั๑", "(̲̅:̲̅:̲̅:̲̅[̲̅ ̲̅]̲̅:̲̅:̲̅:̲̅)", "•.★*...", ".:｡✿*ﾟ‘ﾟ･✿", "۩۞۩", "ᒡ◯ᵔ◯ᒢ", "(■_■)", "(︶︹︶)", "[̲̅$̲̅(̲̅ ͡° ͜ʖ ͡°̲̅)̲̅$̲̅]", "┣▇▇▇═──", "<º)))><", "><(((º>", "[̲̅$̲̅(̲̅2οο̲̅)̲̅$̲̅]", "[̲̅$̲̅(̲̅5̲̅)̲̅$̲̅]", "[̲̅$̲̅(̲̅1̲̅)̲̅$̲̅]", "ƸӜƷ", "ಠ_ಠ", "くコ:彡", "ε/̵͇ /’ ’", "෴", "Ꮬ", "✥", "๑", "✧", "︵‿ヽ(°□° )ノ︵‿", "꧁𒀱", "亗『", "(❍ᴥ❍ʋ)", "| (• ◡•)|", "(◕‿◕)", "ლ(́◉◞౪◟◉)‵ლ", "ლ(╹◡╹ლ)", "ლ(ಠ益ಠლ)", "ლ(´ڡლ)", "☜(˚▽˚)☞", "(/) (°,,°) (/)", "(/) (°,", "(；一_一)", "(●´ω｀●)", "( ́ ◕◞ε◟◕)", "(づ￣ ³￣)づ", "\\ (•◡•) /", "o(╥﹏╥)o", "╘[◉﹃◉]╕", "(╯3╰)", "(◑‿◐)", "(⊙ω⊙)", "|◔◡◉|", "(✪㉨✪)", "(ʘᗩʘ')", "(╥_╥)", "(¬‿¬)", "( ﾟヮﾟ)", "( ･_･)♡", "ಠ▃ಠ", "⊙︿⊙", "◉_◉", "◉◡◉", "⊙﹏⊙", "(✿｡✿)", "(⊙ヮ⊙)", "ಠoಠ", "ب_ب", "◘_◘", "(ಥ_ಥ)", "(ಠ_ಠ)", "ᕦ(ò_óˇ)ᕤ", "(ಥ﹏ಥ)", "(ᵔᴥᵔ)", "ʕ•ᴥ•ʔ", "( ͡ᵔ ͜ʖ ͡ᵔ )", "༼ つ ◕_◕ ༽つ", "( ͡° ͜ʖ ͡°)", "꧁•༆", "☆࿐ཽ༵༆༒꧁𓊈𒆜", "꒰⑅•ᴗ•⑅꒱", "• ۝ ", "⍋*∞*｡*∞*⍋", "(=^‥^=)", "♪(๑ᴖ◡ᴖ๑)♪", "┏༼ ◉ ╭╮ ◉༽┓", "／(=･ x ･=)＼", "︻╦̵̵͇ ╤──", "【≽ܫ≼】", "....φ(︶▽︶)φ....", "／(≧ x ≦)＼", "ଲ(ⓛ ω ⓛ)ଲ", "≪ °❈° ≫", "ψ( ` ∇ ´ )ψ", "(✿◕‿◕)", "█▬█ █ ▀█▀", "≪•◦ ❈ ◦•≫", "V●ᴥ●V", "句_句", "(=⌒‿‿⌒=)", "(◐‿◑)", "( ऀืົཽ₍₍ළ₎₎ ऀืົཽ)", "(^=◕ᴥ◕=^)", "U・ᴥ・U", "(◣_◢)", "❦𝓜𝓲𝓼𝓼", "❖Ƭʜᴇ", "-~*'¨¯¨'*·~㊅", "ヾ(◍’౪`◍)ﾉﾞ", "⁞ つ: •̀ ⌂ •́ : ⁞-︻╦̵̵͇̿̿̿̿══╤─ ", "ก็็็็็็็็็็็็็ʕ•͡ᴥ•ʔ ก้้้้้้้้้้้", "(҂`з´).っ︻デ═一", "•^v^–[", "٩͡๏̯͡๏۶", "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽", "凸(^_^)凸", "（ミ●ω●ミ）", "░▒▓█►─═", ".•°¤*(¯`★´¯)*¤° ", "●´❤`●", "• ₊°✧︡ ˗ ˏ ˋ  ❤ˎˊ ˗ ", "❣", "웃ღ ▣", "╔╣♥❀", "꒰♥☿♥", "(♥‿♥)🎔", "❣凸❣", "♚♥☿♥ ", "•¤»((¯ღ¯))«¤•", "<(-_-)>", "(♛‿♛)", "<(・ε・)>", "(•̪●)", "༼♥ل͜♥༽", "▄︻̷̿┻̿═━一", "┌(メ▼▼)┘", "ʕ灬￫ᴥ￩灬ʔ", "⊂▶ᴥ◀⊃", "꒰•̫͡•ོ꒱", "{♥‿♥}", "(⊗_⊙)", "<{Φ_Φ}>", "(*ΘェΘ*)", "ε[-ิิ_•ิ]з", "(^人^)", "∙∙∙∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ", "|!¤*'~°l||l°►", "*¸ „„.•~¹°”ˆ˜¨♡", "* • • ◕◕════♣", "-·=»‡«=·-", "\\.·´¯`·->", "☰☲☷", "ღ(¯`◕‿◕´¯) ♫ ♪ ♫", "·∙·:‡v:ҳ(`°•", "(¯`*•.¸,¤°´✿.｡.:*", "°̅-̅-̅-’̿\\̵͇̿̿\\°»", "[^--¤--", "<º))))><.·´¯`·. ", "••¤(`×[¤", "«------•}I|[", "(¯`·./¯\\.··{", "- ––––•(-•", "×¤×—{¯´☆✭.¸_", "•—·×¤×·—>", "✿.｡.:* ☆:**:.", "╔╣█╠╗╚ ", "¤ (¯´☆✭.¸_)¤", "*•.¸♥¸.•*—-—", ".·●~◠◡◠✈", "((((¯♀'·.¸(★)", "(¯`·._)♣ ♤ ♥♠(", "º¯`·.·•‹¦[☆]¦›", "☏︎", "٩(××)۶"
)

val DecorationRight = listOf(
    "◄⚽️►●●--●●", "▫▫..🌴", "🎼┏(°.°)┛♪🎧", "◄[🥇]►", "⊱╮🌸✿꧂", "[🍓]ꔊꔊꔊ]", "░▒▓█▇▅▃▂", "꧂ღ╭⊱♥≺", "҂Ϟϟ¤º•°¯\\", "彡★", "˙·٠•●♥ Ƹ̵̡Ӝ̵̨̄Ʒ ♥●•٠·˙", "o͡͡͡͡͡͡͡͡͡͡͡͡͡͡╮(｡❛ᴗ❛｡)╭o͡͡͡͡͡͡͡͡͡͡͡͡͡͡ ", "║▌║▌║█│▌", "◇─────◇──◇─◇", "★·.·¯`·.·★", "ミミ⛧", "ミミ★", "人人人", "¯\\_(ツ)_/¯", "»——☠——««", "─━━★", "■━■━■━■", "‿︵‿︵‿︵‿︵‿︵‿︵", "╰─━━━━━─╮", "┗━━━━━━┓", "･ ╏┐", "┬┴┬┴┤", "┍━━ ⋆⋅☆⋅⋆ ━━━━┙", "┍━━✿━━━━┙", "↦↦↦↦↦", "➷➷➷➷➷", "↬↬↬↬↬", "✐✎✐✎✐", "□□□■■■■■■■■", "█▓▒░", "★・・・・・・★", "░▒▓█", "————-««", "  ҉ 　✼", "☆━━━━━━☆", "～●～●", "☆━━━━━━━…‥・", "【☆】★【☆】", "◇─────◇──◇─◇", "❃──❋", "█ ▇ ▆ ▅ ▄ ▂ ▁", "]▉▉▇▆▅▄▃▂", "░▒▓█▇▅▃▂", "_▂▂▃▄▅▆▇▉▉", "ꕥ⊱╮ღ꧂ღ", "─═ڿڰۣڿ☻ڿڰۣڿ═─ ", "꧂ღ╭⊱♥≺", "╰⊱♥⊱╮╰⊱♥⊱╮", "✧∭✧∰✧∭✧", "●▬▬▬๑۩۩๑▬▬▬●", "҂Ϟϟ¤º•°¯\\", "·._.·´¯)", "O.o°¨", "«(·´¯`·.·÷×", "(×´¯`v^·· ·", "<-·´¯`·.", "]^-- - - ", "<·´¯`·»o«·´¯)", "¨*+•ˆ•.(", "•·.·¯`·.·•", "(¯`·._)", "•·´¯°·", "•´¯`•.•..ҳ̸Ҳ̸Ҳ̸ҳ.", "×º°”˜`”°º×", "«·´º´·•[•", " .•° .•° .•°", "ｪｪｪｴエ", "•·.·')", "【★】", "O.o°• ", "©º°¨¨°º©", ">-.¸.·°¯°·.¸.·°", "*l¯l_l¯l•°", "]÷·•)—", "·ï¡÷¡ï·", "εїз", "•°•.•°•", "<-.•° .•°._|¯|_|¯|", "꒰◍•ᴗ•◍꒱", "(^^(-_-)^^)", "]·´)(` .¸", "{-@--«---", "_.·¯)_.·¯)_.·¯)", "«·✦º✦·•[•", "._;'`;_._.'`;", "]^--♡-♥-", "«·♦·[►", "-·=»★«=·- ", "★·.·¯`·.·★", "(♦¯`v^♦·●·-", "●.●.·¯)(★)", "●●--●●--●●", "★¯`·.★★", "(^_^)(●_●)╲", "«《·♫º·•[•♪", "••.•´¯`•.••", "||!¤*'~``~'*¤!|", "O.o°•.•°•", "º-)•º––––", ".•.·´¯)ҳ̸Ҳ̸Ҳ̸ҳ", "°l||l°►", "◄°l||l°", "∙:±‡±÷·∙·", "••÷^v´¯)", "-●´)●··", "●=»>◆<«=●-´¯", "«¤·´¯`ø", ".●¹°¨¯)·●", "•·.·´¯º", "<-·´¯°·.)»", "‹–…·´`·…–›", "‹.·´¯`·.·´`·.", "•´¯)_)¯)•", "[.·´¯`·.]", "•´`·..í", "¯°º¤◆¤º•°¯", ")°¤º°•—›", "…•ˆ•.>", "]¦•–‹Ì¡››", ".●¹°¨¯)·●", "«¯`·.__.·´¯", "_/¯/__/¯/_ ", "•^v^v^v›", "•°¤*´¯`*¤°•", "‹.·´¯`·.·´`·.", "•´`·.·´`•-->", "«----´¯`–--", "»`·.•._.·´¯}", "╱╲╱╳╲╱╲", "╚╝╔╗╚╝╔╗", "╭╮╰╯╭╮╰╯", "¤.·´`·.¤*´¯`", "…•ˆ•.))•—›", ".·´`•´)÷", "«-(¯`v´¯)-«", "", "♡¸.•*", "¨˜ˆ”°¹~•-.„¸", "彡★", " ¯`•.,¸¸,.•´", "♫♪♩·.¸¸.·", "~舞*'¨¯¨'*·~漫-", "✿◉●•◦", "╚»★«╝", "╚»♡«╝", "´*•.¸(*•.¸♥¸.•*´)¸.•*´", "▄▀▀▄▀▀▄", "▄▀▄▀▄▀", "₪₪₪╮", "✖✖✖✖", " ˙·٠•●♥ Ƹ̵̡Ӝ̵̨̄Ʒ ♥●•٠·˙", "[]ðº°˜¨˜°ºð[]", "●¸.•*¨Ƹ̵̡Ӝ̵̨̄Ʒ¨*•.¸●", "╝╔╣█╠╗", ".--ღஐƸ̵̡Ӝ̵̨̄Ʒஐღ--.", "⊱━━━.⋅εïз⋅.━━━⊰", "/)/)/)/)/)/) ", "*̻͙*̥̻͙*̻̥̻͙*̥̻̥̻͙*̻̥̻̥̻͙", ".+ﾟ☆´●_｀*))", "○o。..:*】●>u<)ﾉ", "ᨓᨐᨏ", "⇉⇉⇉", "⇇⇇⇇", "︺︹︺︹", "¸.•*¨*•.¸♥¸.•*¨*•.¸♪¸.•*¨*•.¸", "✿◉●•◦", "•♬•♫•.", "∙∙∙∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ", "« ♥* ¯).«.*¯))", "⚡️¯\\_༼ ಥ ‿ ಥ ༽_/¯⚡", "o͡͡͡͡͡͡͡͡͡͡͡͡͡͡╮(｡❛ᴗ❛｡)╭o͡͡͡͡͡͡͡͡͡͡͡͡͡͡  ", "✧♡✧*¨*•.❥", "ღཾཿ༉ ༘჻ღཾཿ༉ ༘჻ღཾཿ༉ ༘჻ღཾཿ჻", "୧༼ಠ益ಠ༽︻╦╤─", "‿︵‿︵(ಥ﹏ಥ)‿︵‿︵", "̿ ̿ ̿'̿'\\̵͇̿̿\\з=(•_•)=ε/̵͇̿̿/'̿'̿ ̿ ", "三ʅ(；◔౪◔)ʃ", "ԅ[ •́ ﹏ •̀ ]و", "‥…━━━━〇(^~^)", "\\\\\\٩(•́⌄•́๑)و////", "~-<☀️>-~", "~~<💚>~~", "💖<~~><~~", "─═ڿڿۣڿ═─💖─═ڿڿۣڿ═─", "💕\uFEFF༺♥༻❀༺♥༻", "💢🚀🚀💢", "♥•´இº☆.¸¸.•´¯`💜💗", "⭐️☆╮", "【🌩】★【🌩】", "⇇🎄✖🎄✖🎄", "ᨐꔣ🌈", "•°•.•°•❄🌨️ ", "ꕥ🌸■🌼■🌹•·´¯°·", "₪🍟₪🍔₪╮", "⊱╮🌸✿꧂", "︽︾🍍︽︾", "🎼┏(°.°)┛♪🎧", "෴❤️෴", "░▒▒ 💀 ▒▒░", "ᆛᆜᆛᆜ", "ᎲᎲᎲᎲ", "ᙀᙁᙀᙁᙀᙁ", "ဿဿဿ", "൪൪൪൪൪൪", "ഐഐഐ", "ߐߐߐߐߐߐߐߐߐߐ", "ߖܠߖܠߖܠߖܠߖܠ", "ⴍⴖⴍⴖⴍⴖⴍⴖ", "ਸਸਸਸਸਸਸਸ", "ਔਔਔਔਔਔਔ", "ⰎⰎⰎⰎ", "⭜⭝⭜⭝⭜⭝", "✔✓✔✓✔", "ᱰᱰᱰᱰᱰᱰ", "ᙠᙝᙠᙝᙠᙝ", "ဣဣဣဣဣဣ", "႑႑႑႑႑႑႑႑႑", "႘႙႘႙႘႙႘႙႘႙", "༼༽༼༽༼༽༼༽", "ంంంం", "২২২২২২২২", "ਠਠਠਠਠਠਠਠਠ", "ܛܛܛܛܛܛܛܛܛ", "ܓܓܓܓܓܓܓܓ", "ㄣㄣㄣㄣ", "✘✗✘✗✘✗", "✚✚✚✚✚✚", "ᱬᱬᱬᱬ", "ᨎᨎᨎᨎᨎᨎ", "ᨁᨁᨁᨁ", "ᆇᆇᆇᆇᆇ", "ᆛᆛᆛᆛᆛᆛ", "႔႔႔႔႔႔႔", "ഹഹഹഹ", "⼐⼌⼐⼌⼐⼌⼐⼌", "᚛᚜᚛᚜᚛᚜᚛᚜᚛᚜", "⯊⯋⯊⯋⯊⯋", "ᕳᕲ", "ᔐᔑᔐᔑᔐᔑ", "웃❤유", "║░", "⊑⊕⊒", "⊇⊄⊅", "⊼⊻⊼⊻", "≪↺≫", "]]«---<<", "﹀︽︾△︾︽﹀", "︾︽﹀", "༻", "✩", "⦖", "⫷┈┈╯", "𒆜 ༻", "𒆜", "◉●•◦", "○○♢", "♜", "✭", "乂", "⫸", "══█❚", "✫", "☜☆☞", "༻꧂", "✞☬ঔৣ꧂", "✞✞✞", "☬", "▄︻┻═┳一", "╾━╤デ╦︻", "۞", "*꧂", "ঔৣ꧂", "☬☆", "》》☆", "♡♡●◌", "》》", "⁂❂", "ꐠ↝⇘", "៛₪︽", "❅", "⁂⁑⁎", "ꐠ↝", "*★*:;;;;;:*★*", "*☆*――*☆*", "*:..。o○☆○o。..:*", "○*:;;;:*○", "★｡+ﾟ☆ﾟ+｡", "・。。・゜゜・。。・゜★", "━━━━━★", "*†*†*†*†*†*", "★☆(´・ω・)★", "☆*ﾟ ゜ﾟ*☆", "::::::::::::::::☆", "■□■□■□■□■", "○●○●○●○●○", "(｡>ωω<｡)", "◆´・ω・◆", "★*ﾟ*☆*ﾟ*★", "♡o｡.｡o♡", "оО〇・-・〇Оо", "[̲̅$̲̅(̲̅ιοο̲̅)̲̅$̲̅]", "︻̷ ┻ ═━一", "*•.¸¸♫", "┌∩┐(◣_◢)┌∩┐", "︻╦╤─", "()==[:::::::::>", "ˁ˚ᴥ˚ˀ", "( . Y . )", "︻┳デ═—", "✯╾━╤デ╦︻✯", "๑۩ﺴ۩๑", "๑۩۞۩๑", "๑•ิ.•ั๑", "(̲̅:̲̅:̲̅:̲̅[̲̅ ̲̅]̲̅:̲̅:̲̅:̲̅)", "...*★.•", "✿*ﾟ‘ﾟ･✿.｡.", "۩۞۩", "ᒡ◯ᵔ◯ᒢ", "(■_■)", "(︶︹︶)", "[̲̅$̲̅(̲̅ ͡° ͜ʖ ͡°̲̅)̲̅$̲̅]", "──═▇▇▇┣", "><(((º>", "<º)))><", "[̲̅$̲̅(̲̅2οο̲̅)̲̅$̲̅]", "[̲̅$̲̅(̲̅5̲̅)̲̅$̲̅]", "[̲̅$̲̅(̲̅1̲̅)̲̅$̲̅]", "ƸӜƷ", "ಠ_ಠ", "くコ:彡", "ε/̵͇ /’ ’", "෴", "Ꮬ", "✥", "๑", "✧", "︵‿ヽ(°□° )ノ︵‿", "𒀱꧂", "』亗", "(❍ᴥ❍ʋ)", "|(•◡ •) |", "(◕‿◕)", "ლ(́◉◞౪◟◉)‵ლ", "ლ(╹◡╹ლ)", "(ლಠ益ಠ)ლ", "ლ(´ڡლ)", "☜(˚▽˚)☞", "(/) (°,,°) (/)", ",°) (/)", "(；一_一)", "(●´ω｀●)", "( ́ ◕◞ε◟◕)", "(づ￣ ³￣)づ", "\\ (•◡•) /", "o(╥﹏╥)o", "╘[◉﹃◉]╕", "(╯3╰)", "(◑‿◐)", "(⊙ω⊙)", "|◉◡◔|", "(✪㉨✪)", "(ʘᗩʘ')", "(╥_╥)", "(¬‿¬)", "( ﾟヮﾟ)", "♡(･_･ )", "ಠ▃ಠ", "⊙︿⊙", "◉_◉", "◉◡◉", "⊙﹏⊙", "(✿｡✿)", "(⊙ヮ⊙)", "ಠoಠ", "ب_ب", "◘_◘", "(ಥ_ಥ)", "(ಠ_ಠ)", "ᕦ(ˇò_ó)ᕤ", "(ಥ﹏ಥ)", "(ᵔᴥᵔ)", "ʕ•ᴥ•ʔ", "( ͡ᵔ ͜ʖ ͡ᵔ )", "༼ つ ◕_◕ ༽つ", "( ͡° ͜ʖ ͡°)", "༆•꧂", "𒆜𓊉꧂༒༆࿐ཽ༵☆", "꒰⑅•ᴗ•⑅꒱", " ۝ •", "⍋*∞*｡*∞*⍋", "(=^‥^=)", "♪(๑ᴖ◡ᴖ๑)♪", "┏༼ ◉ ╭╮ ◉༽┓", "／(=･ x ･=)＼", "︻╦̵̵͇ ╤──", "【≽ܫ≼】", "....φ(︶▽︶)φ....", "／(≧ x ≦)＼", "ଲ(ⓛ ω ⓛ)ଲ", "≪ °❈° ≫", "ψ( ` ∇ ´ )ψ", "(◕‿◕✿)", "█▬█ █ ▀█▀", "≪•◦ ❈ ◦•≫", "V●ᴥ●V", "句_句", "(=⌒‿‿⌒=)", "(◐‿◑)", "( ऀืົཽ₍₍ළ₎₎ ऀืົཽ)", "(^=◕ᴥ◕=^)", "U・ᴥ・U", "(◣_◢)", "V͇ I͇ P͇", "V͇ I͇ P͇", "㊅~*'¨¯¨'*·~-", "ヾ(◍’౪`◍)ﾉﾞ", "└། ๑ _ ๑ །┘", "ก็็็็็็็็็็็็็ʕ•͡ᴥ•ʔ ก้้้้้้้้้้้", "└། ๑ _ ๑ །┘", "]–^v^•", "٩͡๏̯͡๏۶", "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽", "凸(^_^)凸", "（ミ●ω●ミ）", "═─◄█▓▒░", "°¤*(¯´★`¯)*¤°•.", "●´❤`●", "˗  ˏˋ 🎔ˎˊ ˗  ✧︡ °", "유 ↩", "▣ ღ웃", "❀❥╠╗", "♥☿♥꒱", "🎔(♥‿♥)", "❣凸❣", "♥☿♥♚", "•¤»((¯♥¯))«¤•", "<(-_-)>", "(♛‿♛) ", "<(・ε・)>", "(•̪●)", "༼♥ل͜♥༽", "<(o_o)>", "┌(▼▼メ)┘", "ʕ灬￫ᴥ￩灬ʔ", "⊂▶ᴥ◀⊃", "꒰•̫͡•ོ꒱", "{♥‿♥}", "(⊗_⊙)", "<{Φ_Φ}>", "(*ΘェΘ*)", "ε[-ิิ_•ิ]з", "(^人^)", "ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙∙∙∙", "◄°l||l°~'*¤!|", "♡¨˜ˆ”°¹~•.„¸*", "♣════◕◕ • •*", "-·=»‡«=·-", "<-·´¯`·./", "☰☲☷", "♫ ♪ ♫ (¯`◕‿◕´¯)ღ", "•°´)ҳ:v‡:·∙·", "*.:｡.✿`°¤,¸.•*´¯)", "«·°/̵͇̿̿/’̿-̅-̅-̅°", "--¤--^]", ".·´¯`·.¸><((((º>", "¤]×´)¤••", "]|I{•------»", "}··./¯\\.·´¯)", "•-)•–––– -", "_¸.✭☆´¯}—×¤×", "<—·×¤×·—•", ".:**:.☆*.:｡.✿", "╝╔╣█╠╗", "¤(_¸.✭☆´¯) ¤", " —-—*•.¸♥¸.•*", "✈◠◡◠~●·.", "(★)¸.·'♂ ´¯))))", ")♣ ♤ ♥♠(¯`·._)", "‹¦[☆]¦›•·.·´¯º", "☏︎", "٩(××)۶"
)

//val t = "\uFEFF"

enum class DecorationSide() {
    LEFT, RIGHT
}




