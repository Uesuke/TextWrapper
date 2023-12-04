document.addEventListener('DOMContentLoaded', function () {
    var copyButton = document.getElementById('copy');
    var resultText = document.getElementById('result');

    copyButton.addEventListener('click', function () {
        // 結果のテキストを取得
        var textToCopy = resultText.innerText;

        // テキストエリアを作成し、コピーするテキストを設定
        var textArea = document.createElement('textarea');
        textArea.value = textToCopy;

        // テキストエリアを画面外に配置
        textArea.style.position = 'fixed';
        textArea.style.top = '0';
        textArea.style.left = '0';
        textArea.style.opacity = '0';

        // テキストエリアを body に追加
        document.body.appendChild(textArea);

        // テキストエリアを選択してコピー
        textArea.select();
        document.execCommand('copy');

        // 不要になったテキストエリアを削除
        document.body.removeChild(textArea);

        // コピー完了メッセージなどを表示（任意）
        alert('コピーしました: ' + textToCopy);
    });
});
