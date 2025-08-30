function onSuccess(stCode,data,msg) {
    return { StatusCode: stCode,Status:"Success", data, Message: msg, }
}

function onError(stCode,error,msg) {
    return { StatusCode: stCode, error, Message:msg, Status:"Error"}
}

function onLoginSuccess(stCode, token, msg) {
    return { statusCode: stCode, status: "success", token, msg };
  }

module.exports = { onSuccess, onError, onLoginSuccess };