const stripe = Stripe('pk_test_51SHe8kKvSoBXIEK9EebJPoTf5ExoshXEVcvbE6qcEX0RLKHsqorPiG5HMVn4x5JpeCoUikwJkELCtdi3wLYUp2o500ki3ZhWBe');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});