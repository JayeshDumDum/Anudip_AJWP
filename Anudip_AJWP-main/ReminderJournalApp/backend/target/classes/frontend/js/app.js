const API_URL = "http://localhost:8081/api/journal";

document.addEventListener("DOMContentLoaded", () => {

  const journalText = document.getElementById("journalText");
  const saveBtn = document.getElementById("saveBtn");
  const historyBtn = document.getElementById("historyBtn");
  const historyPanel = document.getElementById("historyPanel");
  const historyList = document.getElementById("historyList");
  const closeHistory = document.getElementById("closeHistory");

  if (!journalText || !saveBtn || !historyBtn) {
    console.error("Required elements missing");
    return;
  }

  /* LOAD LAST ENTRY */
  async function loadJournal() {
    const res = await fetch(API_URL);
    const data = await res.json();
    if (data.length) {
      journalText.value = data[data.length - 1].content;
    }
  }

  /* SAVE */
  saveBtn.addEventListener("click", async () => {
    const content = journalText.value.trim();
    if (!content) return alert("Write something first");

    await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ content })
    });

    alert("Saved ✅");
  });

  /* HISTORY OPEN */
  historyBtn.addEventListener("click", async (e) => {
    e.stopPropagation();
    historyPanel.classList.remove("hidden");
    loadHistory();
  });

  /* HISTORY LOAD */
  async function loadHistory() {
    historyList.innerHTML = "";

    const res = await fetch(API_URL);
    const data = await res.json();

    if (!data.length) {
      historyList.innerHTML = "<li>No past entries yet ✨</li>";
      return;
    }

    data.reverse().forEach(entry => {
      const li = document.createElement("li");
      li.innerHTML = `
        <strong>${new Date(entry.createdAt).toDateString()}</strong>
        <span>${entry.content.slice(0, 80)}...</span>
      `;

      li.onclick = () => {
        journalText.value = entry.content;
        historyPanel.classList.add("hidden");
      };

      historyList.appendChild(li);
    });
  }

  /* CLOSE HISTORY */
  closeHistory.addEventListener("click", () => {
    historyPanel.classList.add("hidden");
  });

  document.querySelector(".history-sheet")
    .addEventListener("click", e => e.stopPropagation());

  historyPanel.addEventListener("click", () => {
    historyPanel.classList.add("hidden");
  });

  loadJournal();
});
