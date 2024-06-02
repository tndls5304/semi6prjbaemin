



document.getElementById("nextButton").addEventListener("click", function() {

	window.location.href = "/baemin/member/reviewStatusWriter"
});





const emojiButtons = document.querySelectorAll('.emoji-button');


emojiButtons.forEach(button => {
	button.addEventListener('click', () => {

		emojiButtons.forEach(btn => btn.classList.remove('active'));

		button.classList.add('active');
	});
});


const optionButtons = document.querySelectorAll('.option');

let selectedOption = null;


optionButtons.forEach(button => {
	button.addEventListener('click', () => {

		selectedOption = button.textContent;

		localStorage.setItem('selectedOption', selectedOption);
	});
});


